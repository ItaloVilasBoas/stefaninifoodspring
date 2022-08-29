package com.stefanini.stefaninifoodspring.dto;

import java.sql.Date;

public class OrdersDTO {

    private Long orderID;

    private String clientID;

    private Long productID;
    
    private Date date;

    private String paymentMethod;

    private double totalPrice;

    public OrdersDTO(Long orderID, String clientID, Long productID, Date date, String paymentMethod, double totalPrice){
        this.orderID = orderID;
        this.clientID = clientID;
        this.productID = productID;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.totalPrice = totalPrice;
    }

    public OrdersDTO() {
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
