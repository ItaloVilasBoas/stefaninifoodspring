package com.stefanini.stefaninifoodspring.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stefanini.stefaninifoodspring.dto.OrdersDTO;
import com.stefanini.stefaninifoodspring.model.ClientAccount;
import com.stefanini.stefaninifoodspring.model.Orders;
import com.stefanini.stefaninifoodspring.model.Product;
import com.stefanini.stefaninifoodspring.model.VendorAccount;
import com.stefanini.stefaninifoodspring.service.ClientAccountService;
import com.stefanini.stefaninifoodspring.service.OrdersService;
import com.stefanini.stefaninifoodspring.service.ProductService;
import com.stefanini.stefaninifoodspring.service.VendorAccountService;

@RestController
public class OrdersController {
    
    private final OrdersService ordersService;
    private final ClientAccountService clientService;
    private final ProductService productService;
    private final VendorAccountService vendorAccountService;
    
    @Autowired
    public OrdersController(OrdersService ordersService, ClientAccountService clientService,
            ProductService productService, VendorAccountService vendorAccountService) {
        this.ordersService = ordersService;
        this.clientService = clientService;
        this.productService = productService;
        this.vendorAccountService = vendorAccountService;
    }
    /* GERAR LISTA DE TODOS OS PEDIDOS */
    @GetMapping(value = "/pedidos")
    public List<Orders> getAllOrders(){
        return ordersService.findAll();
    }
    /* ENCONTRAR PEDIDO ESPECIFICO ATRAVES DO ID*/
    @GetMapping(value = "/pedidos/{id}")
    public Orders getOrderById(@PathVariable Long id){
        try{
            return ordersService.findById(id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /* CRIAR PEDIDO */
    @PostMapping("/pedidos")
    public Orders creatOrders(@RequestBody OrdersDTO order){
        try{
            ClientAccount client = clientService.findById(order.getClientID());
            Product product = productService.findById(order.getProductID());
            return ordersService.save(new Orders(null, client, product, order.getDate(), order.getPaymentMethod(), order.getTotalPrice()));
        }catch(Exception e){
            e.printStackTrace();        
            return null;
        }
    }
    /* ATUALIZAR PEDIDO */
    @PutMapping("/pedidos/{id}")
    public Orders updatOrders(@PathVariable Long id, @RequestBody OrdersDTO order){
        try{
            ClientAccount client = clientService.findById(order.getClientID());
            Product product = productService.findById(order.getProductID());
            return ordersService.save(new Orders(id, client, product, order.getDate(), order.getPaymentMethod(), order.getTotalPrice()));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /* DELETAR PEDIDO */
    @DeleteMapping("/pedidos/{id}")
    public Orders deleteOrders(@PathVariable Long id){
        return ordersService.delete(id);
    }

    /* METODO PARA VERIFICAR SE O CODIGO HASH PERTENCE A ALGUM EMAIL DE CLIENTE */
    public ClientAccount autenticaHash(int hash){
        for(ClientAccount c : clientService.findAll()){
            if(c.getEmail().hashCode() == hash){
                return c;
            }
        }
        return null;
    }
    /* CRIAR PEDIDOS ATRAVES DE UMA REQUISICAO DO SITE */
    @PostMapping("StefaniniFood/{storeSlug}/{emailHash}/{productID}")
    public String createOrder(@PathVariable String storeSlug, @PathVariable int emailHash, @PathVariable Long productID) throws Exception{
        ClientAccount cliente = autenticaHash(emailHash);
        if(cliente == null)
            return null;
        Product product = productService.findById(productID);
        VendorAccount store = vendorAccountService.findBySlug(storeSlug);
        ordersService.save(new Orders(null, cliente, product, Date.valueOf(LocalDate.now()), "débito", store.getShippingTax()));
        return "Pedido cadastrado!";
    }
    /* GERAR LISTA DE TODOS OS PEDIDOS QUE O CLIENTE JA COMPROU E MOSTRAR EM UMA MODEL AND VIEW */
    @GetMapping("StefaniniFood/cart/{emailHash}")
    public ModelAndView getViewOfOrdersClient(@PathVariable int emailHash){
        ClientAccount cliente = autenticaHash(emailHash);
        ModelAndView mv = new ModelAndView("cart");
        mv.addObject("orders", ordersService.findByClient(cliente.getEmail()));
        return mv;
    }

}
