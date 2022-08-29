package com.stefanini.stefaninifoodspring.service;

import org.springframework.stereotype.Service;

import com.stefanini.stefaninifoodspring.model.VendorAccount;
import com.stefanini.stefaninifoodspring.repository.VendorAccountRepository;

@Service
public class VendorAccountService {

    private final VendorAccountRepository vendorAccountRepository;

    public VendorAccountService(VendorAccountRepository vendorAccountRepository) {
        this.vendorAccountRepository = vendorAccountRepository;
    }
    
    public java.util.List<VendorAccount> findAll(){
        return vendorAccountRepository.findAll();
    }

    public VendorAccount findById(String id){
        return vendorAccountRepository.findByEmail(id);
    }

    public VendorAccount findBySlug(String slug){
        return vendorAccountRepository.findBySlug(slug);
    }

    public VendorAccount save(VendorAccount vendor){
        return vendorAccountRepository.save(vendor);
    }
}
