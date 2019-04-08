package com.archetypesoftware.fastspring.webhooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.archetypesoftware.jackson.DateDeserializers.dateTimeOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class SubscriptionActivatedDeserializationTests {
    private ObjectMapper mapper = new ObjectMapper();

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
}
