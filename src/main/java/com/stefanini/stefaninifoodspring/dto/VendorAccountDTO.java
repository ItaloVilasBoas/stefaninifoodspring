package com.stefanini.stefaninifoodspring.dto;

import com.stefanini.stefaninifoodspring.controller.util.Slug;

public class VendorAccountDTO {
    
    private String email;
    
    private String password;

    private String storeName;

    private String vendorName;
    
    private String segment;
    
    private String address;

    private String slug;

    private Double shippingTax;

    public VendorAccountDTO() {
    }

    public VendorAccountDTO(String email, String password, String storeName, String vendorName, String segment,
            String address, Double shippingTax) {
        this.email = email;
        this.password = password;
        this.storeName = storeName;
        this.vendorName = vendorName;
        this.segment = segment;
        this.address = address;
        this.slug = Slug.toSlug(storeName);
        this.shippingTax = shippingTax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Double getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(Double shippingTax) {
        this.shippingTax = shippingTax;
    }
    
}
