package com.stefanini.stefaninifoodspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stefanini.stefaninifoodspring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.vendor.email = :vendor_id")
    List<Product> storeProducts(@Param("vendor_id") String email);
}
