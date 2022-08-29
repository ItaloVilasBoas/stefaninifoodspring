package com.stefanini.stefaninifoodspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stefanini.stefaninifoodspring.model.Product;
import com.stefanini.stefaninifoodspring.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public java.util.List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findAllFromStore(String email){
        return productRepository.storeProducts(email);
    }

    public Product findById(Long id) throws Exception{
        return productRepository.findById(id).
        orElseThrow(() -> new Exception("Produto com id " + id + " nao encontrado"));
    }

    public Product save(Product product){
        return productRepository.save(product);
    }
}
