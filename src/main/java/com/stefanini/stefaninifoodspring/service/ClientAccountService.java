package com.stefanini.stefaninifoodspring.service;

import org.springframework.stereotype.Service;

import com.stefanini.stefaninifoodspring.repository.ClientAccountRepository;
import com.stefanini.stefaninifoodspring.model.ClientAccount;

@Service
public class ClientAccountService {

    private final ClientAccountRepository clientRepository;

    public ClientAccountService(ClientAccountRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    public java.util.List<ClientAccount> findAll(){
        return clientRepository.findAll();
    }

    public ClientAccount findById(String id){
        return clientRepository.findByEmail(id);
    }

    public ClientAccount save(ClientAccount client){
        return clientRepository.save(client);
    }
}
