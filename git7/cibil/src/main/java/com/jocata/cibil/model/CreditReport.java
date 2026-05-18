package com.jocata.cibil.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit_report")
public class CreditReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private int reportId;

    @Temporal(TemporalType.DATE)
    @Column(name = "report_date")
    private Date reportDate;

    @Column(name = "cibil_score")
    private int cibilScore;

    @Column(unique = true, length = 15)
    private String contact;

    // Relationship
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Constructors
    public CreditReport() {}

    // Getters and Setters
    public int getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }
    public Date getReportDate() { return reportDate; }
    public void setReportDate(Date reportDate) { this.reportDate = reportDate; }
    public int getCibilScore() { return cibilScore; }
    public void setCibilScore(Integer cibilScore) { this.cibilScore = cibilScore; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
