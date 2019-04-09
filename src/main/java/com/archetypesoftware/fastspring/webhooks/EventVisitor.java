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



// ----------- << imports@AAAAAAFqAa+rM/dk+Pw= >>
import com.archetypesoftware.fastspring.webhooks.events.SubscriptionActivatedEvent;
import com.archetypesoftware.fastspring.webhooks.events.SubscriptionCanceledEvent;
import com.archetypesoftware.fastspring.webhooks.events.SubscriptionChargeCompletedEvent;
import com.archetypesoftware.fastspring.webhooks.events.SubscriptionDeactivatedEvent;
// ----------- >>

/**
* An interface to be implemented by receiver of the webhook events.
*/

// ----------- << class.annotations@AAAAAAFqAa+rM/dk+Pw= >>
// ----------- >>
public interface EventVisitor {
    /**
    * @param event SubscriptionActivatedEvent
    */

    // ----------- << method.annotations@AAAAAAFqAa/y2vePxXc= >>
    // ----------- >>
    void visit(SubscriptionActivatedEvent event);
    /**
    * @param event
    */

    // ----------- << method.annotations@AAAAAAFqAbBOU/eYIEQ= >>
    // ----------- >>
    void visit(SubscriptionCanceledEvent event);
    /**
    * @param event
    */

    // ----------- << method.annotations@AAAAAAFqAbB/0feh1qQ= >>
    // ----------- >>
    void visit(SubscriptionChargeCompletedEvent event);
    /**
    * @param event
    */

    // ----------- << method.annotations@AAAAAAFqAbDT9verBno= >>
    // ----------- >>
    void visit(SubscriptionDeactivatedEvent event);
// ----------- << interface.extras@AAAAAAFqAa+rM/dk+Pw= >>
// ----------- >>
}