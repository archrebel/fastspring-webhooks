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
public class SubscriptionCanceledDeserializationTests {

    @Mock
    private EventVisitor eventVisitor;

    private ObjectMapper mapper = new ObjectMapper();
    @Test
    public void GIVEN_subscriptionCanceledMessage_WHEN_deserializing_THEN_expectPredefinedValues() throws IOException {
        URL resource = getClass()
                .getClassLoader()
                .getResource("subscriptionCanceled.json");

        SubscriptionCanceledEvent event = (SubscriptionCanceledEvent)
                mapper.readValue(resource, WebHookEvent.class);

        SubscriptionCanceledPayload payload = event.getData();
        CustomerAccount account = payload.getAccount();

        // event
        assertThat(event.getId(), is("R4jhTS-iQJuF9TMBRBzjJg"));
        assertThat(event.isProcessed(), is(false));
        assertThat(event.getCreatedAt(), is(dateTimeOf(1554091889623L)));

        // account
        assertThat(account.getId(), is("N8FjcSWcQNeYCc-suM1O8g"));
        assertThat(account.getFirst(), is("Marcellus"));
        assertThat(account.getLast(), is("Walrus"));
        assertThat(account.getEmail(), is("ne1@all.com"));
        assertThat(account.getCompany(), is("Walrus Promotions Inc."));
        assertThat(account.getPhone(), is(nullValue()));

        // payload
        assertThat(payload.getSubscriptionId(), is("dpr5V3IBQvKwqsGGwQlizw"));
        assertThat(payload.getState(), is("canceled"));
        assertThat(payload.isLive(), is(false));
        assertThat(payload.getDateOfLastUpdate(), is(dateTimeOf(1507764858198L)));
        assertThat(payload.getProductId(), is("falcon-monthly-variation"));
        assertThat(payload.getProductDisplay(), is("Falcon Monthly Subscription"));
        assertThat(payload.getSku(), is("furious10"));
        assertThat(payload.getQuantity(), is(1));
        assertThat(payload.isAdhoc(), is(false));
        assertThat(payload.isAutorenew(), is(false));
        assertThat(payload.getCurrency(), is("USD"));

        assertThat(payload.getPrice(), is(149.95f));
        assertThat(payload.getPriceDisplay(), is("$149.95"));
        assertThat(payload.getPriceInPayoutCurrency(), is(149.95f));

        assertThat(payload.getDiscount(), is(0.0f));
        assertThat(payload.getDiscountDisplay(), is("$0.00"));
        assertThat(payload.getDiscountInPayoutCurrency(), is(0.0f));

        assertThat(payload.getSubtotal(), is(149.95f));
        assertThat(payload.getSubtotalDisplay(), is("$149.95"));
        assertThat(payload.getSubtotalInPayoutCurrency(), is(149.95f));

        assertThat(payload.getDateOfNextCharge(), is(dateTimeOf(1515628800000L)));
        assertThat(payload.getDateOfNextChargeDisplay(), is("1/11/18"));

        assertThat(payload.getEndDate(), is(nullValue()));
        assertThat(payload.getEndDateDisplay(), is(nullValue()));

        assertThat(payload.getDateOfCancelation(), is(dateTimeOf(1507852800000L)));
        assertThat(payload.getDateOfCancelationDisplay(), is("10/13/17"));

        assertThat(payload.getDateOfDeactivation(), is(dateTimeOf(1515542400000L)));
        assertThat(payload.getDateOfDeactivationDisplay(), is("1/10/18"));

        assertThat(payload.getSequence(), is(1));
        assertThat(payload.getPeriods(), is(0));
        assertThat(payload.getRemainingPeriods(), is(0));

        assertThat(payload.getValidFrom(), is(dateTimeOf(1507680000000L)));

        assertThat(payload.getIntervalUnit(), is("month"));
        assertThat(payload.getIntervalLength(), is(3));
    }

    @Test
    public void GIVEN_canceledMonthlyWebhook_WHEN_deserialized_THEN_assertPredefinedValues() throws IOException {
        URL resource = getClass()
                .getClassLoader()
                .getResource("event-monthly-subscription-cancel.json");

        Notification notification = mapper.readValue(resource, Notification.class);

        doAnswer(invocationOnMock -> {
            SubscriptionCanceledEvent event = invocationOnMock.getArgument(0);
            SubscriptionCanceledPayload payload = event.getData();

            // subscription data
            assertThat(payload.getProductId(), is("falcon-plus-monthly-subscription-individual"));
            assertThat(payload.getDateOfLastUpdate(), is(dateTimeOf(1554091889618L)));
            assertThat(payload.getSubscriptionId(), is("c5XWkUQiQSyqrDTHM8J5Kw"));
            assertThat(payload.isLive(), is(false));
            assertThat(payload.getState(), is("canceled"));
            assertThat(payload.getQuantity(), is(1));

            assertThat(payload.getValidFrom(), is(dateTimeOf(1554076800000L)));
            assertThat(payload.getIntervalUnit(), is("month"));
            assertThat(payload.getIntervalLength(), is(1));

            CustomerAccount account = payload.getAccount();
            assertThat(account.getId(), is("MpQe-PVBQnOguo9A_Pz8Dg"));
            assertThat(account.getFirst(), is("John"));
            assertThat(account.getLast(), is("Doe"));
            assertThat(account.getEmail(), is("john.doe@gmail.com"));
            assertThat(account.getCompany(), is(nullValue()));
            assertThat(account.getPhone(), is("064444333"));

            return null;
        }).when(eventVisitor).visit((SubscriptionCanceledEvent) any());

        assertThat(notification.getEvents(), hasSize(1));

        // assert values
        notification.process(eventVisitor);

        // verify invocation
        verify(eventVisitor, only()).visit((SubscriptionCanceledEvent) notification.getEvents().get(0));
    }

    @Test
    public void GIVEN_canceledYearlyWebhook_WHEN_deserialized_THEN_assertPredefinedValues() throws IOException {
        URL resource = getClass()
                .getClassLoader()
                .getResource("event-yearly-subscription-cancel.json");

        Notification notification = mapper.readValue(resource, Notification.class);

        doAnswer(invocationOnMock -> {
            SubscriptionCanceledEvent event = invocationOnMock.getArgument(0);
            SubscriptionCanceledPayload payload = event.getData();

            // subscription data
            assertThat(payload.getProductId(), is("falcon-plus-annual-subscription-individual-license"));
            assertThat(payload.getDateOfLastUpdate(), is(dateTimeOf(1554090861640L)));
            assertThat(payload.getSubscriptionId(), is("r1LtQnrIS5KpDIoGQaeuHg"));
            assertThat(payload.isLive(), is(false));
            assertThat(payload.getState(), is("canceled"));
            assertThat(payload.getQuantity(), is(1));

            assertThat(payload.getValidFrom(), is(dateTimeOf(1554076800000L)));
            assertThat(payload.getIntervalUnit(), is("year"));
            assertThat(payload.getIntervalLength(), is(1));

            CustomerAccount account = payload.getAccount();
            assertThat(account.getId(), is("MpQe-PVBQnOguo9A_Pz8Dg"));
            assertThat(account.getFirst(), is("John"));
            assertThat(account.getLast(), is("Doe"));
            assertThat(account.getEmail(), is("john.doe@gmail.com"));
            assertThat(account.getCompany(), is(nullValue()));
            assertThat(account.getPhone(), is("064444333"));

            return null;
        }).when(eventVisitor).visit((SubscriptionCanceledEvent) any());

        assertThat(notification.getEvents(), hasSize(1));

        // assert values
        notification.process(eventVisitor);

        // verify invocation
        verify(eventVisitor, only()).visit((SubscriptionCanceledEvent) notification.getEvents().get(0));
    }
}
