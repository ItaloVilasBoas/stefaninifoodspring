package com.stefanini.stefaninifoodspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stefanini.stefaninifoodspring.model.ClientAccount;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {
    @Query("SELECT c FROM ClientAccount c WHERE c.email = :email")
    ClientAccount findByEmail(@Param("email") String id);
}