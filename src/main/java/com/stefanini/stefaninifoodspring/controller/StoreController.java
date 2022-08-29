package com.stefanini.stefaninifoodspring.controller;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.stefanini.stefaninifoodspring.model.ClientAccount;
import com.stefanini.stefaninifoodspring.model.Product;
import com.stefanini.stefaninifoodspring.model.VendorAccount;
import com.stefanini.stefaninifoodspring.service.ClientAccountService;
import com.stefanini.stefaninifoodspring.service.ProductService;
import com.stefanini.stefaninifoodspring.service.VendorAccountService;

@Controller
public class StoreController {
    private final ClientAccountService clientService;
    private final VendorAccountService vendorAccountService;
    private final ProductService productService;
    
    @Autowired
    public StoreController(VendorAccountService vendorAccountService, ProductService productService, ClientAccountService clientService) {
        this.vendorAccountService = vendorAccountService;
        this.productService = productService;
        this.clientService = clientService;
    }
    /* METODO DUPLICADO EM ORDERSCONTROLLER*/
    public ClientAccount autenticaHash(int hash){
        for(ClientAccount c : clientService.findAll()){
            if(c.getEmail().hashCode() == hash){
                return c;
            }
        }
        return null;
    }
    /* METODO PARA MOSTRAR O CONTEUDO DA LOJA */
    @GetMapping("StefaniniFood/{storeSlug}/{emailHash}")
    public ModelAndView showProductsFromStore(@PathVariable String storeSlug, @PathVariable int emailHash){
        ModelAndView mv = new ModelAndView("store");
        ClientAccount cliente = autenticaHash(emailHash);
        if(cliente == null)
            return null;
        VendorAccount store = vendorAccountService.findBySlug(storeSlug);
        mv.addObject("frete", store.getShippingTax());
        mv.addObject("cliente", emailHash);
        mv.addObject("products", productService.findAllFromStore(store.getEmail()));
        return mv;
    }

    /* METODO PARA CRIAR UMA URL PARA AS IMAGENS QUE ESTAO NO BANCO DE DADOS */
    @GetMapping("StefaniniFood/product/image/{id}")
    public void showProductImage(@PathVariable Long id, HttpServletResponse response) throws Exception {
        response.setContentType("image/jpeg");
        Product product = productService.findById(id);
        InputStream is = new ByteArrayInputStream(product.getImage());
        IOUtils.copy(is, response.getOutputStream());
    }
}