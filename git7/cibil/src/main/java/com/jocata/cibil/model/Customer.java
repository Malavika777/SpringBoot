package com.jocata.cibil.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int cusId;

    @Column(name = "pan_number", unique = true, length = 20)
    private String panNumber;

    @Column(name = "aadhaar_number", unique = true, length = 20)
    private String adhaarNumber;

    @Column(name = "full_name", length = 50)
    private String fullName;

    private String email;

    private String mobile;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String gender;

    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CreditReport> creditReports = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CreditAccount> creditAccounts = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Enquiry> enquiries = new ArrayList<>();

    public Customer() {}

    public int getCusId() { return cusId; }
    public void setCusId(Integer customerId) { this.cusId = customerId; }
    public String getPanNumber() { return panNumber; }
    public void setPanNumber(String panNumber) { this.panNumber = panNumber; }
    public String getAdhaarNumber() { return adhaarNumber; }
    public void setAdhaarNumber(String aadhaarNumber) { this.adhaarNumber = aadhaarNumber; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
