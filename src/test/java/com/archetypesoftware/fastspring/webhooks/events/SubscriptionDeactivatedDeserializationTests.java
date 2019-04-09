package com.archetypesoftware.fastspring.webhooks.events;

import com.archetypesoftware.fastspring.webhooks.WebHookEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static com.archetypesoftware.jackson.DateDeserializers.dateTimeOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SubscriptionDeactivatedDeserializationTests {
    private ObjectMapper mapper = new ObjectMapper();
    @Test
    public void GIVEN_deactivatedMessage_WHEN_deserialized_THEN_findExpectedValues() throws IOException {
        URL resource = getClass()
                .getClassLoader()
                .getResource("subscriptionDeactivated.json");

        SubscriptionDeactivatedEvent event = (SubscriptionDeactivatedEvent)
                mapper.readValue(resource, WebHookEvent.class);

        SubscriptionDeactivatedPayload payload = event.getData();
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
        assertThat(account.getCompany(), is("IndoChina Exports, Inc."));
        assertThat(account.getPhone(), is(nullValue()));

        // payload
        assertThat(payload.getSubscriptionId(), is("Du0BMOFlR3W8spSdUh8QrQ"));
        assertThat(payload.getState(), is("deactivated"));
        assertThat(payload.isLive(), is(false));
        assertThat(payload.getDateOfLastUpdate(), is(dateTimeOf(1508177103541L)));
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

        assertThat(payload.getEndDate(), is(dateTimeOf(1508112000000L)));
        assertThat(payload.getEndDateDisplay(), is("10/16/17"));

        assertThat(payload.getDateOfCancelation(), is(dateTimeOf(1508112000000L)));
        assertThat(payload.getDateOfCancelationDisplay(), is("10/16/17"));

        assertThat(payload.getDateOfDeactivation(), is(nullValue()));
        assertThat(payload.getDateOfDeactivationDisplay(), is(nullValue()));

        assertThat(payload.getSequence(), is(1));
        assertThat(payload.getPeriods(), is(0));
        assertThat(payload.getRemainingPeriods(), is(0));

        assertThat(payload.getValidFrom(), is(dateTimeOf(1507680000000L)));

        assertThat(payload.getIntervalUnit(), is("month"));
        assertThat(payload.getIntervalLength(), is(3));
    }
}
