package com.archetypesoftware.fastspring.webhooks.events;

import com.archetypesoftware.fastspring.webhooks.EventVisitor;
import com.archetypesoftware.fastspring.webhooks.Notification;
import com.archetypesoftware.fastspring.webhooks.WebHookEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URL;

import static com.archetypesoftware.jackson.DateDeserializers.dateTimeOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionActivatedDeserializationTests {
    private ObjectMapper mapper = new ObjectMapper();

    @Mock
    private EventVisitor eventVisitor;

    @Test
    public void GIVEN_subscriptionActivatedMessage_WHEN_deserialized_THEN_expectedValuesPresent() throws IOException {
        URL resource = getClass()
                .getClassLoader()
                .getResource("subscriptionActivated.json");

        SubscriptionActivatedEvent webHookEvent = (SubscriptionActivatedEvent)
                mapper.readValue(resource, WebHookEvent.class);

        SubscriptionActivatedPayload payload = webHookEvent.getData();
        CustomerAccount account = payload.getAccount();

        assertThat(webHookEvent.getId(), is("R4jhTS-iQJuF9TMBRBzjJg"));
        assertThat(webHookEvent.getCreatedAt(), is(dateTimeOf(1554091889623L)));
        assertThat(webHookEvent.isLive(), equalTo(false));

        assertThat(account.getId(), equalTo("MpQe-PVBQnOguo9A_Pz8Dg"));
        assertThat(account.getFirst(), equalTo("John"));
        assertThat(account.getLast(), equalTo("Doe"));
        assertThat(account.getEmail(), equalTo("john.doe@gmail.com"));
        assertThat(account.getCompany(), equalTo("Anonymous"));
        assertThat(account.getPhone(), equalTo("+12344321"));

        assertThat(payload.getSubscriptionId(), is("c5XWkUQiQSyqrDTHM8J5Kw"));
        assertThat(payload.getDateOfLastUpdate(), is(dateTimeOf(1554091889618L)));
        assertThat(payload.getState(), is("active"));
        assertThat(payload.isLive(), is(false));
        assertThat(payload.getCurrency(), is("EUR"));

        assertThat(payload.getProductId(), is("sample-product-id"));
        assertThat(payload.getProductDisplay(), is("Sample Product Monthly Subscription"));

        // pricing
        assertThat(payload.getQuantity(), is(1));
        assertThat(payload.getPrice(), is(13.0F));
        assertThat(payload.getPriceDisplay(), is("€13.00"));

        assertThat(payload.getDiscount(), is(0F));
        assertThat(payload.getDiscountDisplay(), is("€0.00"));

        assertThat(payload.getSubtotal(), is(13.0F));
        assertThat(payload.getSubtotalDisplay(), is("€13.00"));

        assertThat(payload.getPriceInPayoutCurrency(), is(14.07F));
        assertThat(payload.getDiscountInPayoutCurrency(), is(0F));
        assertThat(payload.getSubtotalInPayoutCurrency(), is(14.07F));

        // subscription

        assertThat(payload.getBillingSequence(), is(1));
        assertThat(payload.getValidFrom(), is(dateTimeOf(1554076800000L)));
        assertThat(payload.getValidFromDisplay(), is("4/1/19"));

        assertThat(payload.getIntervalUnit(), is("month"));
        assertThat(payload.getIntervalLength(), is(1));

        // next charge
        assertThat(payload.getDateOfNextCharge(), is(dateTimeOf(1556668800000L)));
        assertThat(payload.getDateOfNextChargeDisplay(), is("5/1/19"));

        assertThat(payload.getNextChargeCurrency(), is("EUR"));
        assertThat(payload.getNextChargeTotal(), is(13F));
        assertThat(payload.getNextChargeTotalDisplay(), is("€13.00"));

        assertThat(payload.getNextChargeTotalInPayoutCurrency(), is(14.07F));

        // next notification
        assertThat(payload.getNextNotificationDate(), is(dateTimeOf(1556064000000L)));
        assertThat(payload.getNextNotificationType(), is("PAYMENT_REMINDER"));
    }


    @Test
    public void GIVEN_monthlySubscriptionActivated_WHEN_deserialized_THEN_foundExpectedValues() throws IOException {
        URL resource = getClass()
                .getClassLoader()
                .getResource("event-monthly-subscription-activated.json");

        Notification notification = mapper.readValue(resource, Notification.class);

        // setup visitor
        doAnswer(invocationOnMock -> {
            SubscriptionActivatedEvent event = invocationOnMock.getArgument(0);
            SubscriptionActivatedPayload payload = event.getData();

            // subscription data
            assertThat(payload.getProductId(), is("falcon-plus-monthly-subscription-individual"));
            assertThat(payload.getDateOfLastUpdate(), is(dateTimeOf(1554091889618L)));
            assertThat(payload.getSubscriptionId(), is("c5XWkUQiQSyqrDTHM8J5Kw"));
            assertThat(payload.isLive(), is(false));
            assertThat(payload.getState(), is("active"));
            assertThat(payload.getQuantity(), is(1));

            assertThat(payload.getValidFrom(), is(dateTimeOf(1554076800000L)));
            assertThat(payload.getIntervalUnit(), is("month"));
            assertThat(payload.getIntervalLength(), is(1));
            assertThat(payload.getDateOfNextCharge(), is(dateTimeOf(1556668800000L)));

            // pricing, customer currency
            assertThat(payload.getCurrency(), is("EUR"));
            assertThat(payload.getPrice(), is(13f));
            assertThat(payload.getDiscount(), is(0f));
            assertThat(payload.getSubtotal(), is(payload.getPrice()));

            // pricing, payout currency
            assertThat(payload.getDiscountInPayoutCurrency(), is(0f));
            assertThat(payload.getSubtotalInPayoutCurrency(), is(payload.getPriceInPayoutCurrency()));
            assertThat(payload.getPriceInPayoutCurrency(), is(14.07f));

            CustomerAccount account = payload.getAccount();
            assertThat(account.getId(), is("MpQe-PVBQnOguo9A_Pz8Dg"));
            assertThat(account.getFirst(), is("John"));
            assertThat(account.getLast(), is("Doe"));
            assertThat(account.getEmail(), is("john.doe@gmail.com"));
            assertThat(account.getCompany(), is(nullValue()));
            assertThat(account.getPhone(), is("fdsaasdf"));

            return null;
        }).when(eventVisitor).visit((SubscriptionActivatedEvent) any());

        assertThat(notification.getEvents(), hasSize(1));

        // assert values
        notification.process(eventVisitor);

        // verify invocation
        verify(eventVisitor, only()).visit((SubscriptionActivatedEvent) notification.getEvents().get(0));
    }

    @Test
    public void GIVEN_yearlySubscriptionActivated_WHEN_deserialized_THEN_expectedValuesPresent() throws IOException {
        URL resource = getClass()
                .getClassLoader()
                .getResource("event-yearly-subscription-activated.json");

        Notification notification = mapper.readValue(resource, Notification.class);

        doAnswer(invocationOnMock -> {
            SubscriptionActivatedEvent event = invocationOnMock.getArgument(0);
            SubscriptionActivatedPayload payload = event.getData();

            // subscription data
            assertThat(payload.getProductId(), is("falcon-plus-annual-subscription-individual-license"));
            assertThat(payload.getDateOfLastUpdate(), is(dateTimeOf(1554090861640L)));
            assertThat(payload.getSubscriptionId(), is("r1LtQnrIS5KpDIoGQaeuHg"));
            assertThat(payload.isLive(), is(false));
            assertThat(payload.getState(), is("active"));
            assertThat(payload.getQuantity(), is(1));

            assertThat(payload.getValidFrom(), is(dateTimeOf(1554076800000L)));
            assertThat(payload.getIntervalUnit(), is("year"));
            assertThat(payload.getIntervalLength(), is(1));
            assertThat(payload.getDateOfNextCharge(), is(dateTimeOf(1585699200000L)));

            // pricing, customer currency
            assertThat(payload.getCurrency(), is("EUR"));
            assertThat(payload.getPrice(), is(100f));
            assertThat(payload.getDiscount(), is(0f));
            assertThat(payload.getSubtotal(), is(payload.getPrice()));

            // pricing, payout currency
            assertThat(payload.getDiscountInPayoutCurrency(), is(0f));
            assertThat(payload.getSubtotalInPayoutCurrency(), is(payload.getPriceInPayoutCurrency()));
            assertThat(payload.getPriceInPayoutCurrency(), is(108.26f));

            CustomerAccount account = payload.getAccount();
            assertThat(account.getId(), is("MpQe-PVBQnOguo9A_Pz8Dg"));
            assertThat(account.getFirst(), is("John"));
            assertThat(account.getLast(), is("Doe"));
            assertThat(account.getEmail(), is("john.doe@gmail.com"));
            assertThat(account.getCompany(), is(nullValue()));
            assertThat(account.getPhone(), is("064444333"));

            return null;
        }).when(eventVisitor).visit((SubscriptionActivatedEvent) any());

        assertThat(notification.getEvents(), hasSize(1));

        // assert values
        notification.process(eventVisitor);

        // verify invocation
        verify(eventVisitor, only()).visit((SubscriptionActivatedEvent) notification.getEvents().get(0));
    }
}
