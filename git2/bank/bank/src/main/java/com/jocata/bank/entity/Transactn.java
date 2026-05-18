package com.jocata.bank.entity;

public class Transactn {

    private int id;
    private int cusId;
    private String transType;
    private int accNo;
    private double amount;
    private int senderAcc;
    private int receiverAcc;


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getCusId(){
        return cusId;
    }
    public void setCusId(int cusId){
        this.cusId = cusId;
    }
    public String getTransType(){
        return transType;
    }
    public void setTransType(String transType){
        this.transType = transType;
    }
    public int getAccNo(){
        return accNo;
    }
    public void setAccNo(int accNo){
        this.accNo = accNo;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public int getSenderAcc(){
        return senderAcc;
    }
    public void setSenderAcc(int senderAcc){
        this.senderAcc=senderAcc;
    }
    public int getReceiverAcc(){
        return receiverAcc;
    }
    public void setReceiverAcc(int receiverAcc){
        this.receiverAcc=receiverAcc;
    }

    public String toString() {
        return "Transactn{" +
                "id=" + id +
                ", cusId=" + cusId +
                ", transType='" + transType + '\'' +
                ", accNo=" + accNo +
                ", amount=" + amount +
                ", senderAcc=" + senderAcc +
                ", receiverAcc=" + receiverAcc +
                '}';
    }
}
