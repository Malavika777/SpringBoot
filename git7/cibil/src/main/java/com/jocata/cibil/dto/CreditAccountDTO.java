package com.jocata.cibil.dto;

public class CreditAccountDTO {

    private String institutionName;
    private String accType;
    private int accNo;
    private String ownership;
    private String openDate;
    private String closeDate;
    private int currBal;
    private int sanctAmount;
    private String status;

    public String getInstitutionName() {
        return institutionName;
    }
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
    public String getAccType() {
        return accType;
    }
    public void setAccType(String accType) {
        this.accType = accType;
    }
    public int getAccNo() {
        return accNo;
    }
    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }
    public String getOwnership() {
        return ownership;
    }
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    public String getOpenDate() {
        return openDate;
    }
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
    public String getCloseDate() {
        return closeDate;
    }
    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }
    public int getCurrBal() {
        return currBal;
    }
    public void setCurrBal(int currBal) {
        this.currBal = currBal;
    }
    public int getSanctAmount() {
        return sanctAmount;
    }
    public void setSanctAmount(int sanctAmount) {
        this.sanctAmount = sanctAmount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
