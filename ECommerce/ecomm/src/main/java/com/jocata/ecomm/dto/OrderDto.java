package com.jocata.ecomm.dto;

import ch.qos.logback.core.status.Status;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrderDto {

    private Long id;
    private Long userId;
    private BigDecimal totalAmount;
    private Status status;
    private Timestamp createdAt;
    private List<OrderItemDto> orderItems;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

}
