package com.jocata.cibil.dto;

public class PaymentHistoryDTO {
    private String monthYear;
    private String dpd;
    private String remark;

    public String getMonthYear() { return monthYear; }
    public void setMonthYear(String monthYear) { this.monthYear = monthYear; }
    public String getDpd() { return dpd; }
    public void setDpd(String dpd) { this.dpd = dpd; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
