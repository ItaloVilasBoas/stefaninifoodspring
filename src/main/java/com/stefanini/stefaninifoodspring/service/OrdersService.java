package com.stefanini.stefaninifoodspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stefanini.stefaninifoodspring.model.Orders;
import com.stefanini.stefaninifoodspring.repository.OrdersRepository;

@Service
public class OrdersService {
    
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public java.util.List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    public Orders findById(Long id) throws Exception{
        return ordersRepository.findById(id).orElseThrow(() -> new Exception("Pedido com id " + id + " nao encontrado"));
    }

    public List<Orders> findByClient(String email){
        return ordersRepository.getClientOrders(email);
    }

    public Orders save(Orders order){
        return ordersRepository.save(order);
    }

    public Orders delete(Long id){
        Orders order = null;
        try{
            order = findById(id);
            ordersRepository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return order;
    }
}
