/*
* This code has been generated by the Rebel: a code generator for modern Java.
* 
* For more details, please visit www.archetypesoftware.com.
*
* Drop us a line or two at feedback@archetypesoftware.com. We would love to hear from you.
*/
package com.archetypesoftware.fastspring.webhooks.events;

import java.util.*;
import java.time.*;

import com.fasterxml.jackson.annotation.*;

import com.archetypesoftware.fastspring.webhooks.EventPayload;
// ----------- << imports@AAAAAAFp+P/bR5IUXPw= >>
import com.archetypesoftware.jackson.DateDeserializers;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
// ----------- >>

// ----------- << class.annotations@AAAAAAFp+P/bR5IUXPw= >>
// ----------- >>
public class SubscriptionActivatedPayload extends EventPayload {
    /**
    * ID of the subscription
    */

    @JsonProperty("id")
    // ----------- << attribute.annotations@AAAAAAFp+P/bR5IZFLc= >>
    // ----------- >>
    private String subscriptionId;

    /**
    * date of the most recent change to the subscription
    */

    @JsonProperty("changed")
    // ----------- << attribute.annotations@AAAAAAFp+P/bR5Iboys= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfLastUpdate;

    /**
    * Current status of the subscription: "active", "overdue", "canceled", "deactivated", "trial".
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bR5Idy9s= >>
    // ----------- >>
    private String state;

    /**
    * true if not a test order.
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bR5IeaWw= >>
    // ----------- >>
    private boolean live;

    /**
    * Three-character ISO code for the currency associated with the subscription.
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bR5IfL6w= >>
    // ----------- >>
    private String currency;

    /**
    * product ID of the subscription product
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bR5IgCRY= >>
    // ----------- >>
    private String productId;

    /**
    * Customer-facing Display name of the subscription product.
    */

    @JsonProperty("display")
    // ----------- << attribute.annotations@AAAAAAFp+P/bR5IhGbs= >>
    // ----------- >>
    private String productDisplay;

    /**
    * subscribed quantity of the subscription product
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIjFXc= >>
    // ----------- >>
    private int quantity;

    /**
    * price of the subscription; amount of each subscription charge, in currency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIkwzU= >>
    // ----------- >>
    private float price;

    /**
    * Price of subscription, formatted for display in currency. For instance, "€13.00".
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIlVJw= >>
    // ----------- >>
    private String priceDisplay;

    /**
    * total amount of all discounts associated with the subscription, in currency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJImiLE= >>
    // ----------- >>
    private float discount;

    /**
    * total amount of all discounts associated with the subscription, formatted for display in the currency, for instance "€0.00"
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJInigI= >>
    // ----------- >>
    private String discountDisplay;

    /**
    * subtotal for the subscription, including price and discount, but before tax
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIoe5U= >>
    // ----------- >>
    private float subtotal;

    /**
    * subtotal for the subscription, formatted for display in currency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIpcJ4= >>
    // ----------- >>
    private String subtotalDisplay;

    /**
    * price of the subscription, in the currency of your FastSpring disbursements
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIqee4= >>
    // ----------- >>
    private float priceInPayoutCurrency;

    /**
    * discountInPayoutCurrency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIr/EI= >>
    // ----------- >>
    private float discountInPayoutCurrency;

    /**
    * subtotal for the subscription, in the currency of your FastSpring disbursements
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIsuAI= >>
    // ----------- >>
    private float subtotalInPayoutCurrency;

    /**
    * date of the next scheduled subscription charge.
    */

    @JsonProperty("next")
    // ----------- << attribute.annotations@AAAAAAFp+P/bSJItha4= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfNextCharge;

    /**
    * date of the next scheduled subscription charge, formatted for display based on the language selected for the original subscription order
    */

    @JsonProperty("nextDisplay")
    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIvCOE= >>
    // ----------- >>
    private String dateOfNextChargeDisplay;

    /**
    * sequence number of the current billing period
    */

    @JsonProperty("sequence")
    // ----------- << attribute.annotations@AAAAAAFp+P/bSJIxiHk= >>
    // ----------- >>
    private int billingSequence;

    /**
    * date on which the subscription began, in milliseconds
    */

    @JsonProperty("begin")
    // ----------- << attribute.annotations@AAAAAAFp+P/bSZIzu88= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime validFrom;

    /**
    * date on which the subscription began, formatted for display based on the language selected for the original subscription order
    */

    @JsonProperty("beginDisplay")
    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI1Dvo= >>
    // ----------- >>
    private String validFromDisplay;

    /**
    * Unit of time used in conjunction with intervalLength to determine the subscription's charge interval: "adhoc", "day", "week", "month", "year"
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI3DrU= >>
    // ----------- >>
    private String intervalUnit;

    /**
    * number of intervalUnits per billing period for the subscription
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI4few= >>
    // ----------- >>
    private int intervalLength;

    /**
    * date of the next upcoming charge, formatted for display based on the language selected for the original subscription order
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI5OKc= >>
    // ----------- >>
    private String nextChargeDateDisplay;

    /**
    * three-character ISO code of the currency to be used for the next charge
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI6gDM= >>
    // ----------- >>
    private String nextChargeCurrency;

    /**
    * amount of the next upcoming charge, in the nextChargeCurrency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI7LlQ= >>
    // ----------- >>
    private float nextChargeTotal;

    /**
    * amount of the next upcoming charge, formatted for display based on the nextChargeCurrency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI83a8= >>
    // ----------- >>
    private String nextChargeTotalDisplay;

    /**
    * amount of the next upcoming charge, in the currency of your FastSpring disbursements
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI9FdE= >>
    // ----------- >>
    private float nextChargeTotalInPayoutCurrency;

    /**
    * date of the next customer-facing email notification message, in milliseconds
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI+GAI= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime nextNotificationDate;

    /**
    * type of next customer-facing email notification message: "TRIAL_REMINDER", "PAYMENT_REMINDER", "PAYMENT_OVERDUE"
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZI/kvg= >>
    // ----------- >>
    private String nextNotificationType;

    // ----------- << attribute.annotations@AAAAAAFp+P/bR5IYTvg= >>
    // ----------- >>
    private CustomerAccount account;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public String getState() {
        return state;
    }

    public boolean isLive() {
        return live;
    }

    public String getCurrency() {
        return currency;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductDisplay() {
        return productDisplay;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public String getPriceDisplay() {
        return priceDisplay;
    }

    public float getDiscount() {
        return discount;
    }

    public String getDiscountDisplay() {
        return discountDisplay;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public String getSubtotalDisplay() {
        return subtotalDisplay;
    }

    public float getPriceInPayoutCurrency() {
        return priceInPayoutCurrency;
    }

    public float getDiscountInPayoutCurrency() {
        return discountInPayoutCurrency;
    }

    public float getSubtotalInPayoutCurrency() {
        return subtotalInPayoutCurrency;
    }

    public LocalDateTime getDateOfNextCharge() {
        return dateOfNextCharge;
    }

    public String getDateOfNextChargeDisplay() {
        return dateOfNextChargeDisplay;
    }

    public int getBillingSequence() {
        return billingSequence;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public String getValidFromDisplay() {
        return validFromDisplay;
    }

    public String getIntervalUnit() {
        return intervalUnit;
    }

    public int getIntervalLength() {
        return intervalLength;
    }

    public String getNextChargeDateDisplay() {
        return nextChargeDateDisplay;
    }

    public String getNextChargeCurrency() {
        return nextChargeCurrency;
    }

    public float getNextChargeTotal() {
        return nextChargeTotal;
    }

    public String getNextChargeTotalDisplay() {
        return nextChargeTotalDisplay;
    }

    public float getNextChargeTotalInPayoutCurrency() {
        return nextChargeTotalInPayoutCurrency;
    }

    public LocalDateTime getNextNotificationDate() {
        return nextNotificationDate;
    }

    public String getNextNotificationType() {
        return nextNotificationType;
    }

    public CustomerAccount getAccount() {
        return account;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductDisplay(String productDisplay) {
        this.productDisplay = productDisplay;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPriceDisplay(String priceDisplay) {
        this.priceDisplay = priceDisplay;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setDiscountDisplay(String discountDisplay) {
        this.discountDisplay = discountDisplay;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setSubtotalDisplay(String subtotalDisplay) {
        this.subtotalDisplay = subtotalDisplay;
    }

    public void setPriceInPayoutCurrency(float priceInPayoutCurrency) {
        this.priceInPayoutCurrency = priceInPayoutCurrency;
    }

    public void setDiscountInPayoutCurrency(float discountInPayoutCurrency) {
        this.discountInPayoutCurrency = discountInPayoutCurrency;
    }

    public void setSubtotalInPayoutCurrency(float subtotalInPayoutCurrency) {
        this.subtotalInPayoutCurrency = subtotalInPayoutCurrency;
    }

    public void setDateOfNextCharge(LocalDateTime dateOfNextCharge) {
        this.dateOfNextCharge = dateOfNextCharge;
    }

    public void setDateOfNextChargeDisplay(String dateOfNextChargeDisplay) {
        this.dateOfNextChargeDisplay = dateOfNextChargeDisplay;
    }

    public void setBillingSequence(int billingSequence) {
        this.billingSequence = billingSequence;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidFromDisplay(String validFromDisplay) {
        this.validFromDisplay = validFromDisplay;
    }

    public void setIntervalUnit(String intervalUnit) {
        this.intervalUnit = intervalUnit;
    }

    public void setIntervalLength(int intervalLength) {
        this.intervalLength = intervalLength;
    }

    public void setNextChargeDateDisplay(String nextChargeDateDisplay) {
        this.nextChargeDateDisplay = nextChargeDateDisplay;
    }

    public void setNextChargeCurrency(String nextChargeCurrency) {
        this.nextChargeCurrency = nextChargeCurrency;
    }

    public void setNextChargeTotal(float nextChargeTotal) {
        this.nextChargeTotal = nextChargeTotal;
    }

    public void setNextChargeTotalDisplay(String nextChargeTotalDisplay) {
        this.nextChargeTotalDisplay = nextChargeTotalDisplay;
    }

    public void setNextChargeTotalInPayoutCurrency(float nextChargeTotalInPayoutCurrency) {
        this.nextChargeTotalInPayoutCurrency = nextChargeTotalInPayoutCurrency;
    }

    public void setNextNotificationDate(LocalDateTime nextNotificationDate) {
        this.nextNotificationDate = nextNotificationDate;
    }

    public void setNextNotificationType(String nextNotificationType) {
        this.nextNotificationType = nextNotificationType;
    }

    public void setAccount(CustomerAccount account) {
        this.account = account;
    }

    public void linkAccount(CustomerAccount _account) {
        setAccount(_account);
    }

    public void unlinkAccount() {
        setAccount(null);
    }

// ----------- << class.extras@AAAAAAFp+P/bR5IUXPw= >>
    @SuppressWarnings("unused")
    @JsonProperty("product")
    private void flatMapProduct(Map<String, Object> product) {
        this.productId = (String) product.get("product");
    }

    @Override
    public String toString() {
        return "SubscriptionActivatedPayload{" +
                "subscriptionId='" + subscriptionId + '\'' +
                ", dateOfLastUpdate=" + dateOfLastUpdate +
                ", state='" + state + '\'' +
                ", live=" + live +
                ", currency='" + currency + '\'' +
                ", productId='" + productId + '\'' +
                ", productDisplay='" + productDisplay + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", priceDisplay='" + priceDisplay + '\'' +
                ", discount=" + discount +
                ", discountDisplay='" + discountDisplay + '\'' +
                ", subtotal=" + subtotal +
                ", subtotalDisplay='" + subtotalDisplay + '\'' +
                ", priceInPayoutCurrency=" + priceInPayoutCurrency +
                ", discountInPayoutCurrency=" + discountInPayoutCurrency +
                ", subtotalInPayoutCurrency=" + subtotalInPayoutCurrency +
                ", dateOfNextCharge=" + dateOfNextCharge +
                ", dateOfNextChargeDisplay='" + dateOfNextChargeDisplay + '\'' +
                ", billingSequence=" + billingSequence +
                ", validFrom=" + validFrom +
                ", validFromDisplay='" + validFromDisplay + '\'' +
                ", intervalUnit='" + intervalUnit + '\'' +
                ", intervalLength=" + intervalLength +
                ", nextChargeDateDisplay='" + nextChargeDateDisplay + '\'' +
                ", nextChargeCurrency='" + nextChargeCurrency + '\'' +
                ", nextChargeTotal=" + nextChargeTotal +
                ", nextChargeTotalDisplay='" + nextChargeTotalDisplay + '\'' +
                ", nextChargeTotalInPayoutCurrency=" + nextChargeTotalInPayoutCurrency +
                ", nextNotificationDate=" + nextNotificationDate +
                ", nextNotificationType='" + nextNotificationType + '\'' +
                ", account=" + account +
                '}';
    }

    // ----------- >>
}