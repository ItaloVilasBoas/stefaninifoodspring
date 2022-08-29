package com.stefanini.stefaninifoodspring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    @JsonIncludeProperties(value = {"email"})
    ClientAccount client;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    Product product;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "order_data")
    private Date orderDate;

    @Column(name = "paymentmethod", nullable = false)
    private String paymentMethod;
    
    @Column(name = "total_price")
    private double total;

    public Orders(Long id, ClientAccount client, Product product, Date orderDate, String paymentMethod, double total) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.total = total;
    }

}
