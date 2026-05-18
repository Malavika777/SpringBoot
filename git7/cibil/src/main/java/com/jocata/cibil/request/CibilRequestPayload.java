package com.jocata.cibil.request;

import com.jocata.cibil.model.Customer;
import com.jocata.cibil.model.CreditReport;
import com.jocata.cibil.model.CreditAccount;
import com.jocata.cibil.model.Enquiry;

import java.util.List;

public class CibilRequestPayload {
    private Customer customer;
    private List<CreditReport> creditReports;
    private List<CreditAccount> creditAccounts;
    private List<Enquiry> enquiries;

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<CreditReport> getCreditReports() { return creditReports; }
    public void setCreditReports(List<CreditReport> creditReports) { this.creditReports = creditReports; }

    public List<CreditAccount> getCreditAccounts() { return creditAccounts; }
    public void setCreditAccounts(List<CreditAccount> creditAccounts) { this.creditAccounts = creditAccounts; }

    public List<Enquiry> getEnquiries() { return enquiries; }
    public void setEnquiries(List<Enquiry> enquiries) { this.enquiries = enquiries; }
}
