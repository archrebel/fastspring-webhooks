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



// ----------- << imports@AAAAAAFp+P/bU5PcEds= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAFp+P/bU5PcEds= >>
// ----------- >>
public class Customer {
    // ----------- << attribute.annotations@AAAAAAFp+P/bU5PdrVU= >>
    // ----------- >>
    private String first;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5Pe/eI= >>
    // ----------- >>
    private String last;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5Pfvic= >>
    // ----------- >>
    private String email;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5PgzMc= >>
    // ----------- >>
    private String company;

    // ----------- << attribute.annotations@AAAAAAFp+P/bU5PhRVc= >>
    // ----------- >>
    private String phone;

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

// ----------- << class.extras@AAAAAAFp+P/bU5PcEds= >>

    @Override
    public String toString() {
        return "Customer{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


// ----------- >>
}