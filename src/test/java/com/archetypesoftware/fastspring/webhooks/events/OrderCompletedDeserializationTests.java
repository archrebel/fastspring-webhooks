package com.archetypesoftware.fastspring.webhooks.events;

import com.archetypesoftware.fastspring.webhooks.EventVisitor;
import com.archetypesoftware.fastspring.webhooks.Notification;
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
public class OrderCompletedDeserializationTests {
    private ObjectMapper mapper = new ObjectMapper();

    @Mock
    private EventVisitor eventVisitor;

    @Test
    public void GIVEN_orderCompleted_WHEN_deserialized_THEN_foundExpectedValues() throws IOException {
        URL resource = getClass()
                .getClassLoader()
                .getResource("event-order-completed.json");

        Notification notification = mapper.readValue(resource, Notification.class);

        // setup visitor
        doAnswer(invocationOnMock -> {
            OrderCompletedEvent event = invocationOnMock.getArgument(0);
            OrderCompletedPayload payload = event.getData();

            // order
            assertThat(payload.getOrderId(), is("EBRltgSoSOu5sOHc-xn-wQ"));
            assertThat(payload.getReference(), is("FALCONSOFTWA190413-7806-51197"));
            assertThat(payload.getBuyerReference(), is(nullValue()));
            assertThat(payload.getDateOfUpdate(), is(dateTimeOf(1555170640352L)));
            assertThat(payload.isLive(), is(false));
            assertThat(payload.getBillDescriptor(), is("FS* fsprg.com"));

            assertThat(payload.getCurrency(), is("EUR"));
            assertThat(payload.getPayoutCurrency(), is("USD"));

            assertThat(payload.getTotal(), is(187f));
            assertThat(payload.getTotalDisplay(), is("€187.00"));
            assertThat(payload.getTotalInPayoutCurrency(), is(203.9f));
            assertThat(payload.getTotalInPayoutCurrencyDisplay(), is("USD 203.90"));

            assertThat(payload.getTax(), is(0f));
            assertThat(payload.getTaxDisplay(), is("€0.00"));
            assertThat(payload.getTaxInPayoutCurrency(), equalTo(payload.getTax()));
            assertThat(payload.getTaxInPayoutCurrencyDisplay(), is("USD 0.00"));

            assertThat(payload.getSubtotal(), equalTo(payload.getTotal()));
            assertThat(payload.getSubtotalInPayoutCurrency(), is(payload.getTotalInPayoutCurrency()));

            assertThat(payload.getDiscount(), is(99f));
            assertThat(payload.getDiscountDisplay(), is("€99.00"));

            assertThat(payload.getDiscountWithTax(), equalTo(payload.getDiscount()));
            assertThat(payload.getDiscountWithTaxInPayoutCurrency(), equalTo(payload.getDiscountInPayoutCurrency()));

            // item[0]
            {
                OrderItem orderItem = payload.getItems().get(0);
                assertThat(orderItem.getProduct(), is("falcon-plus-bonus-package-annual-subscription-individual-license"));
                assertThat(orderItem.getDisplay(), is("Falcon Plus Annual Subscription: Bonus Package"));
                assertThat(orderItem.getQuantity(), is(1));

                assertThat(orderItem.getSubtotal(), is(0f));
                assertThat(orderItem.getSubtotalDisplay(), is("€0.00"));
                assertThat(orderItem.getSubtotalInPayoutCurrency(), equalTo(orderItem.getSubtotal()));

                assertThat(orderItem.getDiscount(), is(99f));
                assertThat(orderItem.getDiscountDisplay(), is("€99.00"));
                assertThat(orderItem.getDiscountInPayoutCurrency(), is(107.95f));

                // subscription
                SubscriptionInfo subscription = orderItem.getSubscription();
                assertThat(subscription.getId(), is("rwCAW-OyTL6FD6vk3-EmDg"));
                assertThat(subscription.isActive(), is(true));
                assertThat(subscription.getState(), is("active"));
                assertThat(subscription.getDateOfLastUpdate(), is(dateTimeOf(1555170640182L)));
                assertThat(subscription.getSequence(), is(1));

                assertThat(subscription.getValidFrom(), is(dateTimeOf(1555113600000L)));
                assertThat(subscription.getValidUntil(), is(dateTimeOf(1586736000000L)));

                assertThat(subscription.getDateOfNextCharge(), is(dateTimeOf(1586736000000L)));
                assertThat(subscription.getNextChargeTotal(), is(99f));
                assertThat(subscription.getNextChargeTotalDisplay(), is("€99.00"));
                assertThat(subscription.getNextChargeTotalInPayoutCurrency(), is(107.95f));
                assertThat(subscription.getNextChargeTotalInPayoutCurrencyDisplay(), is("USD 107.95"));

                assertThat(subscription.getNextNotificationType(), is("PAYMENT_REMINDER"));
                assertThat(subscription.getDateOfNextNotification(), is(dateTimeOf(1584057600000L)));
            }
            // item[1]
            {
                OrderItem orderItem = payload.getItems().get(1);
                assertThat(orderItem.getProduct(), is("falcon-plus-bonus-package-individual-license"));
                assertThat(orderItem.getDisplay(), is("First Annual Billing for using Falcon Plus:  Bonus Package"));
                assertThat(orderItem.getQuantity(), is(1));

                assertThat(orderItem.getSubtotal(), is(187f));
                assertThat(orderItem.getSubtotalDisplay(), is("€187.00"));
                assertThat(orderItem.getSubtotalInPayoutCurrency(), equalTo(203.9f));

                assertThat(orderItem.getDiscount(), is(0f));
                assertThat(orderItem.getDiscountDisplay(), is("€0.00"));
                assertThat(orderItem.getDiscountInPayoutCurrency(), is(0f));
            }

            // account
            CustomerAccount account = payload.getAccount();
            assertThat(account.getId(), is("ZVTiqogRRWaJ5ACD8c6fLg"));
            assertThat(account.getFirst(), is("John"));
            assertThat(account.getLast(), is("Doe"));
            assertThat(account.getEmail(), is("john.doe@gmail.com"));
            assertThat(account.getCompany(), is(nullValue()));
            assertThat(account.getPhone(), is("12345678"));

            // customer
            Customer customer = payload.getCustomer();
            assertThat(customer.getFirst(), is(account.getFirst()));
            assertThat(customer.getLast(), is(account.getLast()));
            assertThat(customer.getCompany(), is(account.getCompany()));
            assertThat(customer.getEmail(), is(account.getEmail()));
            assertThat(customer.getPhone(), is(account.getPhone()));

            // payment
            Payment payment = payload.getPayment();
            assertThat(payment.getType(), is("test"));
            assertThat(payment.getBank(), is(nullValue()));
            assertThat(payment.getCreditcard(), is(nullValue()));
            assertThat(payment.getCardEnding(), is("4242"));


            return null;
        }).when(eventVisitor).visit((OrderCompletedEvent) any());

        assertThat(notification.getEvents(), hasSize(1));

        // assert values
        notification.process(eventVisitor);

        // verify invocation
        verify(eventVisitor, only()).visit((OrderCompletedEvent) notification.getEvents().get(0));
    }
}
