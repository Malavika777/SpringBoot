package com.jocata.bank.entity;

public class Account {

    private int id;
    private String accName;
    private String accType;
    private double balance;
    private int cusId;
    private String status;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getAccName(){
        return accName;
    }
    public void setAccName(String accName){
        this.accName=accName;
    }
    public String getAccType(){
        return accType;
    }
    public void setAccType(String accType){
        this.accType=accType;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public int getCusId(){
        return cusId;
    }
    public void setCusId(int cusId){
        this.cusId=cusId;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }

    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accName='" + accName + '\'' +
                ", accType='" + accType + '\'' +
                ", balance=" + balance +
                ", cusId=" + cusId +
                ", status='" + status + '\'' +
                '}';
    }

}
