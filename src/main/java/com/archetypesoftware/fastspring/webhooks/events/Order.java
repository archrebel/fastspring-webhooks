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


// ----------- << imports@AAAAAAFp+P/bS5KXaFw= >>
import com.archetypesoftware.jackson.DateDeserializers;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
// ----------- >>

@JsonIgnoreProperties(ignoreUnknown = true)
// ----------- << class.annotations@AAAAAAFp+P/bS5KXaFw= >>
// ----------- >>
public class Order {
    /**
    * internal order ID
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KkfJ0= >>
    // ----------- >>
    private String id;

    /**
    * customer-visible order reference
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5Kl2rU= >>
    // ----------- >>
    private String reference;

    /**
    * optional purchase order number entered by the customer
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KmqxA= >>
    // ----------- >>
    private String buyerReference;

    /**
    * date of the most recent update to the order record
    */

    @JsonProperty("changed")
    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KnKHE= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfUpdate;

    /**
    * two-character ISO code for the order language
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KpDBs= >>
    // ----------- >>
    private String language;

    /**
    * three-character ISO code for the order currency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5Kqpfo= >>
    // ----------- >>
    private String currency;

    /**
    * three-character ISO code for the currency in which
    * your disbursement will be made
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KrUdE= >>
    // ----------- >>
    private String payoutCurrency;

    /**
    * URL of the customer-facing invoice for this order
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KsA0o= >>
    // ----------- >>
    private String invoiceUrl;

    /**
    * FastSpring-generated customer account ID
    */

    @JsonProperty("account")
    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KtrX4= >>
    // ----------- >>
    private String accountId;

    /**
    * order total in the transaction's currency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KvASc= >>
    // ----------- >>
    private float total;

    /**
    * order total, formatted for display in the transaction's currency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5Kwu2Y= >>
    // ----------- >>
    private String totalDisplay;

    /**
    * order total in the currency of your FastSpring disbursements
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KxLl0= >>
    // ----------- >>
    private float totalInPayoutCurrency;

    // ----------- << attribute.annotations@AAAAAAFqIIsHhm3yTMI= >>
    // ----------- >>
    private String totalInPayoutCurrencyDisplay;

    /**
    * amount of tax
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KyfzE= >>
    // ----------- >>
    private float tax;

    /**
    * amount of tax, formatted for display in the transaction's currency
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJKzQug= >>
    // ----------- >>
    private String taxDisplay;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK0CY8= >>
    // ----------- >>
    private float taxInPayoutCurrency;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK1pFI= >>
    // ----------- >>
    private float subtotal;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK2Zd4= >>
    // ----------- >>
    private String subtotalDisplay;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK3RNE= >>
    // ----------- >>
    private float subtotalInPayoutCurrency;

    // ----------- << attribute.annotations@AAAAAAFqIIqKF2utIFA= >>
    // ----------- >>
    private String subtotalInPayoutCurrencyDisplay;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK4Dbo= >>
    // ----------- >>
    private float discount;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK5Ol4= >>
    // ----------- >>
    private String discountDisplay;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK6e6E= >>
    // ----------- >>
    private float discountInPayoutCurrency;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK77YM= >>
    // ----------- >>
    private float discountWithTax;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK8+lg= >>
    // ----------- >>
    private String discountWithTaxDisplay;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK9Rqw= >>
    // ----------- >>
    private float dixcountWithTaxInPayoutCurrency;

    // ----------- << attribute.annotations@AAAAAAFp+P/bTJK+Z2c= >>
    // ----------- >>
    private String billDescriptor;

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KafPw= >>
    // ----------- >>
    private Payment payment;

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KdKpw= >>
    // ----------- >>
    private Customer customer;

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5Kg7wg= >>
    // ----------- >>
    private Address address;

    // ----------- << attribute.annotations@AAAAAAFp+P/bS5KjO1Q= >>
    // ----------- >>
    private Set<Item> items = new HashSet<>();

    public String getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getBuyerReference() {
        return buyerReference;
    }

    public LocalDateTime getDateOfUpdate() {
        return dateOfUpdate;
    }

    public String getLanguage() {
        return language;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPayoutCurrency() {
        return payoutCurrency;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public String getAccountId() {
        return accountId;
    }

    public float getTotal() {
        return total;
    }

    public String getTotalDisplay() {
        return totalDisplay;
    }

    public float getTotalInPayoutCurrency() {
        return totalInPayoutCurrency;
    }

    public String getTotalInPayoutCurrencyDisplay() {
        return totalInPayoutCurrencyDisplay;
    }

    public float getTax() {
        return tax;
    }

    public String getTaxDisplay() {
        return taxDisplay;
    }

    public float getTaxInPayoutCurrency() {
        return taxInPayoutCurrency;
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

    public String getSubtotalInPayoutCurrencyDisplay() {
        return subtotalInPayoutCurrencyDisplay;
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

    public float getDiscountWithTax() {
        return discountWithTax;
    }

    public String getDiscountWithTaxDisplay() {
        return discountWithTaxDisplay;
    }

    public float getDixcountWithTaxInPayoutCurrency() {
        return dixcountWithTaxInPayoutCurrency;
    }

    public String getBillDescriptor() {
        return billDescriptor;
    }

    public Payment getPayment() {
        return payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Address getAddress() {
        return address;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setBuyerReference(String buyerReference) {
        this.buyerReference = buyerReference;
    }

    public void setDateOfUpdate(LocalDateTime dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPayoutCurrency(String payoutCurrency) {
        this.payoutCurrency = payoutCurrency;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setTotalDisplay(String totalDisplay) {
        this.totalDisplay = totalDisplay;
    }

    public void setTotalInPayoutCurrency(float totalInPayoutCurrency) {
        this.totalInPayoutCurrency = totalInPayoutCurrency;
    }

    public void setTotalInPayoutCurrencyDisplay(String totalInPayoutCurrencyDisplay) {
        this.totalInPayoutCurrencyDisplay = totalInPayoutCurrencyDisplay;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public void setTaxDisplay(String taxDisplay) {
        this.taxDisplay = taxDisplay;
    }

    public void setTaxInPayoutCurrency(float taxInPayoutCurrency) {
        this.taxInPayoutCurrency = taxInPayoutCurrency;
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

    public void setSubtotalInPayoutCurrencyDisplay(String subtotalInPayoutCurrencyDisplay) {
        this.subtotalInPayoutCurrencyDisplay = subtotalInPayoutCurrencyDisplay;
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

    public void setDiscountWithTax(float discountWithTax) {
        this.discountWithTax = discountWithTax;
    }

    public void setDiscountWithTaxDisplay(String discountWithTaxDisplay) {
        this.discountWithTaxDisplay = discountWithTaxDisplay;
    }

    public void setDixcountWithTaxInPayoutCurrency(float dixcountWithTaxInPayoutCurrency) {
        this.dixcountWithTaxInPayoutCurrency = dixcountWithTaxInPayoutCurrency;
    }

    public void setBillDescriptor(String billDescriptor) {
        this.billDescriptor = billDescriptor;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void linkPayment(Payment _payment) {
        setPayment(_payment);
    }

    public void linkCustomer(Customer _customer) {
        setCustomer(_customer);
    }

    public void linkAddress(Address _address) {
        setAddress(_address);
    }

    public void linkItems(Item _items) {
        if (_items != null) {
            getItems().add(_items);
        }
    }

    public void unlinkPayment() {
        setPayment(null);
    }

    public void unlinkCustomer() {
        setCustomer(null);
    }

    public void unlinkAddress() {
        setAddress(null);
    }

    public void unlinkItems(Item _items) {
        if (_items != null) {
            getItems().remove(_items);
        }
    }

    public void unlinkItems(Iterator<Item> it) {
        it.remove();
    }

// ----------- << class.extras@AAAAAAFp+P/bS5KXaFw= >>

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", buyerReference='" + buyerReference + '\'' +
                ", dateOfUpdate=" + dateOfUpdate +
                ", language='" + language + '\'' +
                ", currency='" + currency + '\'' +
                ", payoutCurrency='" + payoutCurrency + '\'' +
                ", invoiceUrl='" + invoiceUrl + '\'' +
                ", accountId='" + accountId + '\'' +
                ", total=" + total +
                ", totalDisplay='" + totalDisplay + '\'' +
                ", totalInPayoutCurrency=" + totalInPayoutCurrency +
                ", totalInPayoutCurrencyDisplay='" + totalInPayoutCurrencyDisplay + '\'' +
                ", tax=" + tax +
                ", taxDisplay='" + taxDisplay + '\'' +
                ", taxInPayoutCurrency=" + taxInPayoutCurrency +
                ", subtotal=" + subtotal +
                ", subtotalDisplay='" + subtotalDisplay + '\'' +
                ", subtotalInPayoutCurrency=" + subtotalInPayoutCurrency +
                ", subtotalInPayoutCurrencyDisplay='" + subtotalInPayoutCurrencyDisplay + '\'' +
                ", discount=" + discount +
                ", discountDisplay='" + discountDisplay + '\'' +
                ", discountInPayoutCurrency=" + discountInPayoutCurrency +
                ", discountWithTax=" + discountWithTax +
                ", discountWithTaxDisplay='" + discountWithTaxDisplay + '\'' +
                ", dixcountWithTaxInPayoutCurrency=" + dixcountWithTaxInPayoutCurrency +
                ", billDescriptor='" + billDescriptor + '\'' +
                ", payment=" + payment +
                ", customer=" + customer +
                ", address=" + address +
                ", items=" + items +
                '}';
    }

// ----------- >>
}