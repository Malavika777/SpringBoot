package com.jocata.cibil.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "enquiry")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enquiry_id")
    private int enqId;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "enquiry_purpose")
    private String enqPurpose;

    @Temporal(TemporalType.DATE)
    @Column(name = "enquiry_date")
    private Date enquiryDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Enquiry() {}

    public int getEnqId() { return enqId; }
    public void setEnqId(Integer enquiryId) { this.enqId = enquiryId; }
    public String getInstitutionName() { return institutionName; }
    public void setInstitutionName(String institutionName) { this.institutionName = institutionName; }
    public String getEnqPurpose() { return enqPurpose; }
    public void setEnqPurpose(String enquiryPurpose) { this.enqPurpose = enquiryPurpose; }
    public Date getEnquiryDate() { return enquiryDate; }
    public void setEnquiryDate(Date enquiryDate) { this.enquiryDate = enquiryDate; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
