package com.stefanini.stefaninifoodspring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.stefanini.stefaninifoodspring.controller.util.Slug;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "vendoraccount")
public class VendorAccount{
    @Id
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;
    
    @Column(name = "store_segment", nullable = false)
    private String segment;
    
    @Column(name = "store_address", nullable = false)
    private String address;
    
    @OneToMany(mappedBy = "vendor")
    private List<Product> products;

    @Column(nullable = false)
    private String slug;

    @Column(name="shipping_tax", nullable = false)
    private Double shippingTax;


    public VendorAccount(String email, String password, String storeName, String vendorName, String segment,
            String address, Double shippingTax) {
        this.email = email;
        this.password = password;
        this.storeName = storeName;
        this.vendorName = vendorName;
        this.segment = segment;
        this.address = address;
        this.shippingTax = shippingTax;
        this.slug = Slug.toSlug(storeName);
    }

}
