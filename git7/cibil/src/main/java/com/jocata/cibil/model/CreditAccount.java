package com.jocata.cibil.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "credit_account")
public class CreditAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accId;

    @Column(name = "institution_name", length = 50)
    private String institutionName;

    @Column(name = "account_type", length = 20)
    private String accType;

    @Column(name = "account_number", unique = true)
    private Long accNo;

    @Column(length = 20)
    private String ownership;

    @Temporal(TemporalType.DATE)
    @Column(name = "open_date")
    private Date openDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "close_date")
    private Date closeDate;

    @Column(name = "current_balance")
    private Double currBalance;

    @Column(name = "sanctioned_amount")
    private Double sanctAmount;

    @Column(length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "creditAccount", cascade = CascadeType.ALL)
    private List<PaymentHistory> paymentHistories = new ArrayList<>();


    public int getAccId() { return accId; }
    public void setAccId(Integer accId) { this.accId = accId; }
    public String getInstitutionName() { return institutionName; }
    public void setInstitutionName(String institutionName) { this.institutionName = institutionName; }
    public String getAccType() { return accType; }
    public void setAccType(String accountType) { this.accType = accountType; }
    public Long getAccNo() { return accNo; }
    public void setAccNo(Long accNo) { this.accNo = accNo; }
    public String getOwnership() { return ownership; }
    public void setOwnership(String ownership) { this.ownership = ownership; }
    public Date getOpenDate() { return openDate; }
    public void setOpenDate(Date openDate) { this.openDate = openDate; }
    public Date getCloseDate() { return closeDate; }
    public void setCloseDate(Date closeDate) { this.closeDate = closeDate; }
    public Double getCurrBalance() { return currBalance; }
    public void setCurrBalance(Double currentBalance) { this.currBalance = currentBalance; }
    public Double getSanctAmount() { return sanctAmount; }
    public void setSanctAmount(Double sanctionedAmount) { this.sanctAmount = sanctionedAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<PaymentHistory> getPaymentHistories() {
        return paymentHistories;
    }
    public void setPaymentHistories(List<PaymentHistory> paymentHistories) {
        this.paymentHistories = paymentHistories;
    }
}
