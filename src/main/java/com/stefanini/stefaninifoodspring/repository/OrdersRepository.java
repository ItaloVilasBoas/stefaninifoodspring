package com.stefanini.stefaninifoodspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stefanini.stefaninifoodspring.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{
    @Query("SELECT o FROM Orders o WHERE o.client.email = :client_id")
    List<Orders> getClientOrders(@Param("client_id") String email);
}
