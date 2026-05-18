package com.jocata.cibil.service;

import com.jocata.cibil.model.Customer;
import com.jocata.cibil.request.CibilRequestPayload;

import java.util.List;

public interface CustomerService {

    public void saveCibilData(CibilRequestPayload payload);
    public Customer getCustomerByPanAndAadhaar(String panNumber, String adhaarNumber);
    Customer createCustomer(Customer customer);
    Customer getCustomerById(int cusId);
    Customer getCustomerByPanOrAdhaar(String pan,String ahdaar);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Customer customer);
    void deleteCustomer(int cusId,String pan,String ahdaar);
}
