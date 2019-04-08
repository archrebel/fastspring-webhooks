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


// ----------- << imports@AAAAAAFp+P/bSZJAIOM= >>
// ----------- >>

@JsonIgnoreProperties(ignoreUnknown = true)
// ----------- << class.annotations@AAAAAAFp+P/bSZJAIOM= >>
// ----------- >>
public class CustomerAccount {
    /**
    * FastSpring-generated customer account ID
    */

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZJBY4E= >>
    // ----------- >>
    private String id;

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZJC49E= >>
    // ----------- >>
    private String first;

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZJDRM8= >>
    // ----------- >>
    private String last;

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZJEEm8= >>
    // ----------- >>
    private String email;

    // ----------- << attribute.annotations@AAAAAAFp+P/bSZJFVgg= >>
    // ----------- >>
    private String company;

    // ----------- << attribute.annotations@AAAAAAFp+P/bSpJGiTE= >>
    // ----------- >>
    private String phone;

    public String getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

// ----------- << class.extras@AAAAAAFp+P/bSZJAIOM= >>
    @SuppressWarnings("unused")
    @JsonProperty("contact")
    private void flatMapContact(Map<String, Object> contact) {
        first = (String) contact.get("first");
        last = (String) contact.get("last");
        email = (String) contact.get("email");
        company = (String) contact.get("company");
        phone = (String) contact.get("phone");
    }
// ----------- >>
}