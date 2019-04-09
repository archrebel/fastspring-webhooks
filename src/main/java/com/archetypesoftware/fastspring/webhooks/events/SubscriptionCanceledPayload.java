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
// ----------- << imports@AAAAAAFqAWy81vC8zFM= >>
import com.archetypesoftware.jackson.DateDeserializers;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
// ----------- >>

// ----------- << class.annotations@AAAAAAFqAWy81vC8zFM= >>
// ----------- >>
public class SubscriptionCanceledPayload extends EventPayload {
    /**
    * ID of the subscription
    */

    @JsonProperty("id")
    // ----------- << attribute.annotations@AAAAAAFqAWy82PD0BhI= >>
    // ----------- >>
    private String subscriptionId;

    // ----------- << attribute.annotations@AAAAAAFqAWy82PD2ABo= >>
    // ----------- >>
    private String state;

    @JsonProperty("changed")
    // ----------- << attribute.annotations@AAAAAAFqAWy82PD31TA= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfLastUpdate;

    /**
    * "true" if not a test order
    */

    // ----------- << attribute.annotations@AAAAAAFqAWy82fD5K1M= >>
    // ----------- >>
    private boolean live;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fD68x0= >>
    // ----------- >>
    private String productId;

    /**
    * optional internal SKU ID (e.g. your part number) for the current product
    */

    // ----------- << attribute.annotations@AAAAAAFqAWy82fD7+e8= >>
    // ----------- >>
    private String sku;

    /**
    * customer-facing Display name of the subscription product
    */

    @JsonProperty("display")
    // ----------- << attribute.annotations@AAAAAAFqAWy82fD8eyE= >>
    // ----------- >>
    private String productDisplay;

    /**
    * subscribed quantity of the subscription product
    */

    // ----------- << attribute.annotations@AAAAAAFqAWy82fD+TfA= >>
    // ----------- >>
    private int quantity;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fD/PkY= >>
    // ----------- >>
    private boolean adhoc;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEACmU= >>
    // ----------- >>
    private boolean autorenew;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEBPbo= >>
    // ----------- >>
    private String currency;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fECRfo= >>
    // ----------- >>
    private float price;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEDwqQ= >>
    // ----------- >>
    private String priceDisplay;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEEYE4= >>
    // ----------- >>
    private float priceInPayoutCurrency;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEFvGw= >>
    // ----------- >>
    private float discount;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEG/YE= >>
    // ----------- >>
    private String discountDisplay;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEHeXo= >>
    // ----------- >>
    private float discountInPayoutCurrency;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEIAZ8= >>
    // ----------- >>
    private float subtotal;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEJjIY= >>
    // ----------- >>
    private String subtotalDisplay;

    // ----------- << attribute.annotations@AAAAAAFqAWy82fEKyeM= >>
    // ----------- >>
    private float subtotalInPayoutCurrency;

    /**
    * date of the next scheduled subscription charge
    */

    @JsonProperty("next")
    // ----------- << attribute.annotations@AAAAAAFqAWy82fELc6s= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfNextCharge;

    /**
    * date of the next scheduled subscription charge, formatted for display based on the language 
    * selected for the original subscription order
    */

    @JsonProperty("nextDisplay")
    // ----------- << attribute.annotations@AAAAAAFqAWy82fENyL0= >>
    // ----------- >>
    private String dateOfNextChargeDisplay;

    /**
    * date on which the subscription was deactivated
    */

    @JsonProperty("end")
    // ----------- << attribute.annotations@AAAAAAFqAWy82fEPEiI= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime endDate;

    /**
    * date on which the subscription was deactivated, formatted for display based on the language
    *  selected for the original subscription order
    */

    @JsonProperty("endDisplay")
    // ----------- << attribute.annotations@AAAAAAFqAWy82vER3io= >>
    // ----------- >>
    private String endDateDisplay;

    /**
    * date on which the subscription was canceled, if applicable
    */

    @JsonProperty("canceledDate")
    // ----------- << attribute.annotations@AAAAAAFqAWy82vETO14= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfCancelation;

    /**
    * date on which the subscription was canceled, if applicable, formatted for display based
    * on the language selected for the original subscription order
    */

    @JsonProperty("canceledDateDisplay")
    // ----------- << attribute.annotations@AAAAAAFqAWy82vEVjP4= >>
    // ----------- >>
    private String dateOfCancelationDisplay;

    /**
    * date on which the subscription was or will be deactivated, if applicable
    * (null if deactivated immediately upon cancellation)
    */

    @JsonProperty("deactivationDate")
    // ----------- << attribute.annotations@AAAAAAFqAWy82vEXxKk= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfDeactivation;

    /**
    * date on which the subscription was or will be deactivated, if applicable, formatted for display
    * based on the language selected for the original subscription order
    */

    @JsonProperty("deactivationDateDisplay")
    // ----------- << attribute.annotations@AAAAAAFqAWy82vEZ+cM= >>
    // ----------- >>
    private String dateOfDeactivationDisplay;

    /**
    * sequence number of the current billing period
    */

    // ----------- << attribute.annotations@AAAAAAFqAWy82vEbWqQ= >>
    // ----------- >>
    private int sequence;

    // ----------- << attribute.annotations@AAAAAAFqAWy82vEcNSU= >>
    // ----------- >>
    private int periods;

    // ----------- << attribute.annotations@AAAAAAFqAWy82vEdTG8= >>
    // ----------- >>
    private int remainingPeriods;

    @JsonProperty("begin")
    // ----------- << attribute.annotations@AAAAAAFqAWy82vEe4w4= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime validFrom;

    // ----------- << attribute.annotations@AAAAAAFqAWy82vEg+08= >>
    // ----------- >>
    private String intervalUnit;

    // ----------- << attribute.annotations@AAAAAAFqAWy82vEhF6I= >>
    // ----------- >>
    private int intervalLength;

    // ----------- << attribute.annotations@AAAAAAFqAWy81/DAgZg= >>
    // ----------- >>
    private CustomerAccount account;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public String getState() {
        return state;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public boolean isLive() {
        return live;
    }

    public String getProductId() {
        return productId;
    }

    public String getSku() {
        return sku;
    }

    public String getProductDisplay() {
        return productDisplay;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAdhoc() {
        return adhoc;
    }

    public boolean isAutorenew() {
        return autorenew;
    }

    public String getCurrency() {
        return currency;
    }

    public float getPrice() {
        return price;
    }

    public String getPriceDisplay() {
        return priceDisplay;
    }

    public float getPriceInPayoutCurrency() {
        return priceInPayoutCurrency;
    }

    public float getDiscount() {
        return discount;
    }

    public String getDiscountDisplay() {
        return discountDisplay;
    }

    public float getDiscountInPayoutCurrency() {
        return discountInPayoutCurrency;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public String getSubtotalDisplay() {
        return subtotalDisplay;
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

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getEndDateDisplay() {
        return endDateDisplay;
    }

    public LocalDateTime getDateOfCancelation() {
        return dateOfCancelation;
    }

    public String getDateOfCancelationDisplay() {
        return dateOfCancelationDisplay;
    }

    public LocalDateTime getDateOfDeactivation() {
        return dateOfDeactivation;
    }

    public String getDateOfDeactivationDisplay() {
        return dateOfDeactivationDisplay;
    }

    public int getSequence() {
        return sequence;
    }

    public int getPeriods() {
        return periods;
    }

    public int getRemainingPeriods() {
        return remainingPeriods;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public String getIntervalUnit() {
        return intervalUnit;
    }

    public int getIntervalLength() {
        return intervalLength;
    }

    public CustomerAccount getAccount() {
        return account;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setProductDisplay(String productDisplay) {
        this.productDisplay = productDisplay;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAdhoc(boolean adhoc) {
        this.adhoc = adhoc;
    }

    public void setAutorenew(boolean autorenew) {
        this.autorenew = autorenew;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPriceDisplay(String priceDisplay) {
        this.priceDisplay = priceDisplay;
    }

    public void setPriceInPayoutCurrency(float priceInPayoutCurrency) {
        this.priceInPayoutCurrency = priceInPayoutCurrency;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setDiscountDisplay(String discountDisplay) {
        this.discountDisplay = discountDisplay;
    }

    public void setDiscountInPayoutCurrency(float discountInPayoutCurrency) {
        this.discountInPayoutCurrency = discountInPayoutCurrency;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setSubtotalDisplay(String subtotalDisplay) {
        this.subtotalDisplay = subtotalDisplay;
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

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setEndDateDisplay(String endDateDisplay) {
        this.endDateDisplay = endDateDisplay;
    }

    public void setDateOfCancelation(LocalDateTime dateOfCancelation) {
        this.dateOfCancelation = dateOfCancelation;
    }

    public void setDateOfCancelationDisplay(String dateOfCancelationDisplay) {
        this.dateOfCancelationDisplay = dateOfCancelationDisplay;
    }

    public void setDateOfDeactivation(LocalDateTime dateOfDeactivation) {
        this.dateOfDeactivation = dateOfDeactivation;
    }

    public void setDateOfDeactivationDisplay(String dateOfDeactivationDisplay) {
        this.dateOfDeactivationDisplay = dateOfDeactivationDisplay;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public void setRemainingPeriods(int remainingPeriods) {
        this.remainingPeriods = remainingPeriods;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public void setIntervalUnit(String intervalUnit) {
        this.intervalUnit = intervalUnit;
    }

    public void setIntervalLength(int intervalLength) {
        this.intervalLength = intervalLength;
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

// ----------- << class.extras@AAAAAAFqAWy81vC8zFM= >>
    @SuppressWarnings("unused")
    @JsonProperty("product")
    private void flatMapProduct(Map<String, Object> product) {
        this.productId = (String) product.get("product");
    }
// ----------- >>
}