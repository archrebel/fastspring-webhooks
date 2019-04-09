/*
* This code has been generated by the Rebel: a code generator for modern Java.
* 
* For more details, please visit www.archetypesoftware.com.
*
* Drop us a line or two at feedback@archetypesoftware.com. We would love to hear from you.
*/
package com.archetypesoftware.fastspring.webhooks;

import java.util.*;
import java.time.*;

import com.fasterxml.jackson.annotation.*;


// ----------- << imports@AAAAAAFp+P/bQJFPjoU= >>
import com.archetypesoftware.fastspring.webhooks.events.*;
import com.archetypesoftware.jackson.DateDeserializers;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
// ----------- >>

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SubscriptionActivatedEvent.class, name = "subscription.activated"),
        @JsonSubTypes.Type(value = SubscriptionChargeCompletedEvent.class, name = "subscription.charge.completed"),
        @JsonSubTypes.Type(value = SubscriptionDeactivatedEvent.class, name = "subscription.deactivated"),
        @JsonSubTypes.Type(value = SubscriptionCanceledEvent.class, name = "subscription.canceled")
})
@JsonIgnoreProperties(ignoreUnknown = true)
// ----------- << class.annotations@AAAAAAFp+P/bQJFPjoU= >>
// ----------- >>
public class WebHookEvent<T extends EventPayload> {
    /**
    * Unique ID of the event.
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bQJFRtw4= >>
    // ----------- >>
    private String id;

    /**
    * Whether this event is for live data instead of test data.
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bQJFSYu0= >>
    // ----------- >>
    private boolean live;

    /**
    * Whether this event has been marked processed. For a new event this will always be false.
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bQJFTLG0= >>
    // ----------- >>
    private boolean processed;

    /**
    * Timestamp for when the event was created.
    */

    @JsonProperty("created")
    // ----------- << attribute.annotations@AAAAAAFp+P/bQJFUvuc= >>
    @JsonDeserialize(using = DateDeserializers.Millis2LocalDateTimeDeserializer.class)
    // ----------- >>
    private LocalDateTime createdAt;

    // ----------- << attribute.annotations@AAAAAAFp+P/bQJFWV9w= >>
    // ----------- >>
    private T data;

    public String getId() {
        return id;
    }

    public boolean isLive() {
        return live;
    }

    public boolean isProcessed() {
        return processed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public T getData() {
        return data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setData(T data) {
        this.data = data;
    }

// ----------- << class.extras@AAAAAAFp+P/bQJFPjoU= >>
// ----------- >>
}