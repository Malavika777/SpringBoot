package com.jocata.ecomm.entity;


import jakarta.persistence.*;

@Entity
@Table(name="payments")
public class Payment {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    private Method paymentMethod;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    private String transactionId;

    public enum Status {
        SUCCESS,FAILED,PENDING
    }
    public enum Method {
        CARD,COD,UPI
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Method getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(Method paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public Status getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(Status paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}
