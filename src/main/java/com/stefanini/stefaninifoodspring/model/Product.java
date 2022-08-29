package com.stefanini.stefaninifoodspring.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    @JsonIgnore
    private byte[] image;
    
    @Column(name = "in_stock", columnDefinition = "boolean default true", nullable = false)
    private boolean inStock;
    
    @Column(name = "product_name", nullable = false)
    private String name;
    
    @Column(name = "product_description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;
    
    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    @JsonIgnore
    private VendorAccount vendor;

    @OneToMany(mappedBy="product")
    @JsonIgnore
    private Set<Orders> shoppingCart;

    public Product(Long id, boolean inStock, String name, String description, double price, VendorAccount vendor) {
        this.id = id;
        this.inStock = inStock;
        this.name = name;
        this.description = description;
        this.price = price;
        this.vendor = vendor;
    }
}
