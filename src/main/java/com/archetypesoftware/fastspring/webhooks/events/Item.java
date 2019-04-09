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


// ----------- << imports@AAAAAAFp+P/bU5PqVK8= >>
// ----------- >>

@JsonIgnoreProperties(ignoreUnknown = true)
// ----------- << class.annotations@AAAAAAFp+P/bU5PqVK8= >>
// ----------- >>
public class Item {
    // ----------- << attribute.annotations@AAAAAAFp+P/bU5PrgRY= >>
    // ----------- >>
    private String product;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5Ps+Cw= >>
    // ----------- >>
    private int quantity;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5Pt7/4= >>
    // ----------- >>
    private String display;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5PuCws= >>
    // ----------- >>
    private float subtotal;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5PvF08= >>
    // ----------- >>
    private String subtotalDisplay;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5Pwekw= >>
    // ----------- >>
    private float subtotalInPayoutCurrency;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5PxMQM= >>
    // ----------- >>
    private float discount;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5PyvEo= >>
    // ----------- >>
    private String discountDisplay;

    // ----------- << attribute.annotations@AAAAAAFp+P/bVJPzT6M= >>
    // ----------- >>
    private float discountInPayoutCurrency;

    @JsonProperty("subscription")
    // ----------- << attribute.annotations@AAAAAAFp+P/bVJP0zCY= >>
    // ----------- >>
    private String subscriptionId;

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDisplay() {
        return display;
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

    public float getDiscount() {
        return discount;
    }

    public String getDiscountDisplay() {
        return discountDisplay;
    }

    public float getDiscountInPayoutCurrency() {
        return discountInPayoutCurrency;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDisplay(String display) {
        this.display = display;
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

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setDiscountDisplay(String discountDisplay) {
        this.discountDisplay = discountDisplay;
    }

    public void setDiscountInPayoutCurrency(float discountInPayoutCurrency) {
        this.discountInPayoutCurrency = discountInPayoutCurrency;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

// ----------- << class.extras@AAAAAAFp+P/bU5PqVK8= >>
// ----------- >>
}