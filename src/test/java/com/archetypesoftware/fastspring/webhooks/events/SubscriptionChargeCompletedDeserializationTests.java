package com.archetypesoftware.fastspring.webhooks.events;

import com.archetypesoftware.fastspring.webhooks.WebHookEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

import static com.archetypesoftware.jackson.DateDeserializers.dateTimeOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SubscriptionChargeCompletedDeserializationTests {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void GIVEN_chargeCompletedMessage_WHEN_deserialized_THEN_valuesExpected() throws IOException {
        URL resource = getClass()
                .getClassLoader()
                .getResource("subscriptionChargeCompleted.json");

        SubscriptionChargeCompletedEvent event = (SubscriptionChargeCompletedEvent)
                objectMapper.readValue(resource, WebHookEvent.class);

        SubscriptionChargeCompletedPayload payload = event.getData();
        Order order = payload.getOrder();
        Payment payment = order.getPayment();
        Customer customer = order.getCustomer();
        Address address = order.getAddress();
        Set<Item> items = order.getItems();

        assertThat(order.getId(), is("f4AD0ASGT-aLxvCgZhwqYQ"));
        assertThat(order.getReference(), is("FUR190114-3398-66103B"));
        assertThat(order.getBuyerReference(), nullValue());
        assertThat(order.getDateOfUpdate(), is(dateTimeOf(1547509655131L)));
        assertThat(order.getCurrency(), is("USD"));
        assertThat(order.getPayoutCurrency(), is("USD"));
        assertThat(order.getInvoiceUrl(), is("https://furiousfalcon.onfastspring.com/account/order/FUR190114-3398-66103B/invoice"));
        assertThat(order.getAccountId(), is("N8FjcSWcQNeYCc-suM1O8g"));
        assertThat(order.getTotal(), is(14.95F));
        assertThat(order.getTotalDisplay(), is("$14.95"));
        assertThat(order.getTotalInPayoutCurrency(), is(14.95F));
        assertThat(order.getTotalInPayoutCurrencyDisplay(), is("$14.95"));
        assertThat(order.getTax(), is(0F));
        assertThat(order.getTaxDisplay(), is("$0.00"));
        assertThat(order.getTaxInPayoutCurrency(), is(0F));
        assertThat(order.getSubtotal(), is(14.95F));
        assertThat(order.getSubtotalDisplay(), is("$14.95"));
        assertThat(order.getSubtotalInPayoutCurrency(), is(14.95F));
        assertThat(order.getSubtotalInPayoutCurrencyDisplay(), is("$14.95"));
        assertThat(order.getDiscount(), is(0F));
        assertThat(order.getDiscountDisplay(), is("$0.00"));
        assertThat(order.getDiscountInPayoutCurrency(), is(0F));
        assertThat(order.getDiscountWithTax(), is(0F));
        assertThat(order.getDiscountWithTaxDisplay(), is("$0.00"));
        assertThat(order.getBillDescriptor(), is("FS* fsprg.com"));
        // payment
        assertThat(payment.getType(), is("test"));
        // customer
        assertThat(customer.getFirst(), is("Leeroy"));
        assertThat(customer.getLast(), is("Jenkins"));
        assertThat(customer.getEmail(), is("ne1@all.com"));
        assertThat(customer.getCompany(), is("Chicken Danger, Inc."));
        assertThat(customer.getPhone(), nullValue());
        // address
        assertThat(address.getCity(), is("Santa Barbara"));
        assertThat(address.getRegionCode(), is("CA"));
        assertThat(address.getRegionDisplay(), is("California"));
        assertThat(address.getPostalCode(), is("93101"));
        assertThat(address.getCountry(), is("US"));

        assertThat(items, hasSize(1));
        Item item = items.iterator().next();

        assertThat(item.getProduct(), is("radar-monthly"));
        assertThat(item.getQuantity(), is(1));
        assertThat(item.getDisplay(), is("Radar Monthly Subscription"));
        assertThat(item.getSubtotal(), is(14.95F));
        assertThat(item.getSubtotalDisplay(), is("$14.95"));
        assertThat(item.getSubtotalInPayoutCurrency(), is(14.95F));
        assertThat(item.getDiscount(), is(0F));
        assertThat(item.getDiscountDisplay(), is("$0.00"));
        assertThat(item.getDiscountInPayoutCurrency(), is(0F));
        assertThat(item.getSubscriptionId(), is("D6_GWaK_TNKimir8D9hE2w"));

        // payload
        assertThat(payload.getCurrency(), is("USD"));
        assertThat(payload.getTotal(), is(14.95F));
        assertThat(payload.getStatus(), is("successful"));
        assertThat(payload.getTimestamp(), is(dateTimeOf(1547509653577L)));
        assertThat(payload.getSequence(), is(2));

        CustomerAccount account = payload.getAccount();
        assertThat(account.getId(), is("N8FjcSWcQNeYCc-suM1O8g"));
        assertThat(account.getFirst(), is("Leeroy"));
        assertThat(account.getLast(), is("Jenkins"));
        assertThat(account.getEmail(), is("ne1@all.com"));
        assertThat(account.getCompany(), is("Chicken Danger, Inc."));
        assertThat(account.getPhone(), is(nullValue()));

        Subscription subscription = payload.getSubscription();
        assertThat(subscription.getId(), is("D6_GWaK_TNKimir8D9hE2w"));
        assertThat(subscription.isActive(), is(true));
        assertThat(subscription.getState(), is("active"));
        assertThat(subscription.getDateOfLastUpdate(), is(dateTimeOf(1547052708104L)));
        assertThat(subscription.isLive(), is(false));
        assertThat(subscription.getCurrency(), is("USD"));
        assertThat(subscription.getAccount(), is("N8FjcSWcQNeYCc-suM1O8g"));
        assertThat(subscription.getProduct(), is("radar-monthly"));
        assertThat(subscription.getSku(), is(nullValue()));
        assertThat(subscription.getDisplay(), is("Radar Monthly Subscription"));
        assertThat(subscription.getQuantity(), is(1));
        assertThat(subscription.isAdhoc(), is(false));
        assertThat(subscription.isAutoRenew(), is(true));
        assertThat(subscription.getPrice(), is(14.95f));
        assertThat(subscription.getPriceDisplay(), is("$14.95"));
        assertThat(subscription.getPriceInPayoutCurrency(), is(14.95F));
        assertThat(subscription.getDiscount(), is(0f));
        assertThat(subscription.getDiscountDisplay(), is("$0.00"));
        assertThat(subscription.getDiscountInPayoutCurrency(), is(0f));
        assertThat(subscription.getSubtotal(), is(14.95f));
        assertThat(subscription.getSubtotalDisplay(), is("$14.95"));
        assertThat(subscription.getSubtotalInPayoutCurrency(), is(14.95f));
        assertThat(subscription.getDateOfNextCharge(), is(dateTimeOf(1552089600000L)));
        assertThat(subscription.getCanceledDate(), is(nullValue()));
        assertThat(subscription.getDeactivationDate(), is(nullValue()));
        assertThat(subscription.getSequence(), is(2));
        assertThat(subscription.getValidFrom(), is(dateTimeOf(1546992000000L)));
        assertThat(subscription.getIntervalUnit(), is("month"));
        assertThat(subscription.getIntervalLength(), is(1));
        assertThat(subscription.getNextChargeCurrency(), is("USD"));
        assertThat(subscription.getNextChargeDate(), is(dateTimeOf(1552089600000L)));
        assertThat(subscription.getNextChargeDateDisplay(), is( "3/9/19"));
        assertThat(subscription.getNextChargeTotal(), is(14.95f));
        assertThat(subscription.getNextChargeTotalDisplay(), is("$14.95"));
        assertThat(subscription.getNextChargeTotalInPayoutCurrency(), is(14.95f));
        assertThat(subscription.getNextNotificationDate(), is(dateTimeOf(1551484800000L)));
        assertThat(subscription.getNextNotificationDateDisplay(), is("3/2/19"));
        assertThat(subscription.getNextNotificationType(), is("PAYMENT_REMINDER"));
    }
}
