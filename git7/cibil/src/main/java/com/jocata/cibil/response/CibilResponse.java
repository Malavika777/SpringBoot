package com.jocata.cibil.response;

import com.jocata.cibil.model.Customer;

public class CibilResponse {
    private Customer customer;

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    private boolean status;
    private String message;
    private int cibilScore;
}
