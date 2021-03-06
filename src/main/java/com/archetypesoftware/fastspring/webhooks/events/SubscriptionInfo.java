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


// ----------- << imports@AAAAAAFqFaNF3w6vl2k= >>
import com.archetypesoftware.jackson.DateDeserializers;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
// ----------- >>

@JsonIgnoreProperties(ignoreUnknown = true)
// ----------- << class.annotations@AAAAAAFqFaNF3w6vl2k= >>
// ----------- >>
public class SubscriptionInfo {
    // ----------- << attribute.annotations@AAAAAAFqFaNz7Q9pMEU= >>
    // ----------- >>
    private String id;

    // ----------- << attribute.annotations@AAAAAAFqFaOGfQ/ESJo= >>
    // ----------- >>
    private boolean active;

    // ----------- << attribute.annotations@AAAAAAFqFaPFdRAfNLw= >>
    // ----------- >>
    private String state;

    @JsonProperty("changed")
    // ----------- << attribute.annotations@AAAAAAFqFaPZtBB6M/c= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfLastUpdate;

    // ----------- << attribute.annotations@AAAAAAFqFaWrEhK4JAE= >>
    // ----------- >>
    private int sequence;

    @JsonProperty("begin")
    // ----------- << attribute.annotations@AAAAAAFqFaXLeBMTOKM= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime validFrom;

    @JsonProperty("next")
    // ----------- << attribute.annotations@AAAAAAFqFaUOGBIeNTg= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime validUntil;

    @JsonProperty("nextChargeDate")
    // ----------- << attribute.annotations@AAAAAAFqFailFxW5bbk= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfNextCharge;

    // ----------- << attribute.annotations@AAAAAAFqFakXnBZTsJg= >>
    // ----------- >>
    private float nextChargeTotal;

    // ----------- << attribute.annotations@AAAAAAFqFalReRauTr0= >>
    // ----------- >>
    private float nextChargeTotalInPayoutCurrency;

    // ----------- << attribute.annotations@AAAAAAFqFamBFBcJT2Y= >>
    // ----------- >>
    private String nextChargeTotalDisplay;

    // ----------- << attribute.annotations@AAAAAAFqFamwhhdkQW0= >>
    // ----------- >>
    private String nextChargeTotalInPayoutCurrencyDisplay;

    // ----------- << attribute.annotations@AAAAAAFqFaoJXhf7nn8= >>
    // ----------- >>
    private String nextNotificationType;

    @JsonProperty("nextNotificationDate")
    // ----------- << attribute.annotations@AAAAAAFqFaokPRhWwTM= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime dateOfNextNotification;

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public String getState() {
        return state;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public LocalDateTime getDateOfNextCharge() {
        return dateOfNextCharge;
    }

    public float getNextChargeTotal() {
        return nextChargeTotal;
    }

    public float getNextChargeTotalInPayoutCurrency() {
        return nextChargeTotalInPayoutCurrency;
    }

    public String getNextChargeTotalDisplay() {
        return nextChargeTotalDisplay;
    }

    public String getNextChargeTotalInPayoutCurrencyDisplay() {
        return nextChargeTotalInPayoutCurrencyDisplay;
    }

    public String getNextNotificationType() {
        return nextNotificationType;
    }

    public LocalDateTime getDateOfNextNotification() {
        return dateOfNextNotification;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public void setDateOfNextCharge(LocalDateTime dateOfNextCharge) {
        this.dateOfNextCharge = dateOfNextCharge;
    }

    public void setNextChargeTotal(float nextChargeTotal) {
        this.nextChargeTotal = nextChargeTotal;
    }

    public void setNextChargeTotalInPayoutCurrency(float nextChargeTotalInPayoutCurrency) {
        this.nextChargeTotalInPayoutCurrency = nextChargeTotalInPayoutCurrency;
    }

    public void setNextChargeTotalDisplay(String nextChargeTotalDisplay) {
        this.nextChargeTotalDisplay = nextChargeTotalDisplay;
    }

    public void setNextChargeTotalInPayoutCurrencyDisplay(String nextChargeTotalInPayoutCurrencyDisplay) {
        this.nextChargeTotalInPayoutCurrencyDisplay = nextChargeTotalInPayoutCurrencyDisplay;
    }

    public void setNextNotificationType(String nextNotificationType) {
        this.nextNotificationType = nextNotificationType;
    }

    public void setDateOfNextNotification(LocalDateTime dateOfNextNotification) {
        this.dateOfNextNotification = dateOfNextNotification;
    }

// ----------- << class.extras@AAAAAAFqFaNF3w6vl2k= >>

    @Override
    public String toString() {
        return "SubscriptionInfo{" +
                "id='" + id + '\'' +
                ", active=" + active +
                ", state='" + state + '\'' +
                ", dateOfLastUpdate=" + dateOfLastUpdate +
                ", sequence=" + sequence +
                ", validFrom=" + validFrom +
                ", validUntil=" + validUntil +
                ", dateOfNextCharge=" + dateOfNextCharge +
                ", nextChargeTotal=" + nextChargeTotal +
                ", nextChargeTotalInPayoutCurrency=" + nextChargeTotalInPayoutCurrency +
                ", nextChargeTotalDisplay='" + nextChargeTotalDisplay + '\'' +
                ", nextChargeTotalInPayoutCurrencyDisplay='" + nextChargeTotalInPayoutCurrencyDisplay + '\'' +
                ", nextNotificationType='" + nextNotificationType + '\'' +
                ", dateOfNextNotification=" + dateOfNextNotification +
                '}';
    }

// ----------- >>
}