package com.stefanini.stefaninifoodspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stefanini.stefaninifoodspring.model.VendorAccount;

public interface VendorAccountRepository extends JpaRepository<VendorAccount, Long> {
    @Query("SELECT v FROM VendorAccount v WHERE v.email = :email")
    VendorAccount findByEmail(@Param("email") String id);

    @Query("SELECT v FROM VendorAccount v WHERE v.slug = :slug")
    VendorAccount findBySlug(@Param("slug") String slug);
}
