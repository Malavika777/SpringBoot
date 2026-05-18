package com.jocata.cibil.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment_history")
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private int hisId;

    @Column(name = "month_year")
    private String monthYear;

    private String dpd;

    private String remark;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private CreditAccount creditAccount;

    public PaymentHistory() {}
    public int getHisId() { return hisId; }
    public void setHisId(Integer hisId) { this.hisId = hisId; }
    public String getMonthYear() { return monthYear; }
    public void setMonthYear(String monthYear) { this.monthYear = monthYear; }
    public String getDpd() { return dpd; }
    public void setDpd(String dpd) { this.dpd = dpd; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public CreditAccount getCreditAccount() { return creditAccount; }
    public void setCreditAccount(CreditAccount creditAccount) { this.creditAccount = creditAccount; }
}
