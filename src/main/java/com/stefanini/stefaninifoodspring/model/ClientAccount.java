package com.stefanini.stefaninifoodspring.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "clientaccount")
public class ClientAccount {
    @Id
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy="client")
    @JsonIgnore
    private Set<Orders> shoppingCart;

    public ClientAccount(String email, String password, Set<Orders> shoppingCart) {
        this.email = email;
        this.password = password;
        this.shoppingCart = shoppingCart;
    }

    public ClientAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
