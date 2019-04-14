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


import com.archetypesoftware.fastspring.webhooks.WebHookEvent;
import com.archetypesoftware.fastspring.webhooks.EventVisitor;
// ----------- << imports@AAAAAAFqFYFmhfvIQpw= >>
// ----------- >>

/**
* OrderCompletedEvent encapsulates information contained within 'order.completed' FastSpring webhook. 
* 
* For more information see:
* http://docs.fastspring.com/integrating-with-fastspring/webhooks/order-completed
*/

// ----------- << class.annotations@AAAAAAFqFYFmhfvIQpw= >>
// ----------- >>
public class OrderCompletedEvent extends WebHookEvent<OrderCompletedPayload> {
    /**
    * @param visitor
    */

    // ----------- << method.annotations@AAAAAAFqFYJl//xW+58= >>
    // ----------- >>
    public void accept(EventVisitor visitor) {
    // ----------- << method.body@AAAAAAFqFYJl//xW+58= >>
        visitor.visit(this);
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAFqFYFmhfvIQpw= >>
// ----------- >>
}