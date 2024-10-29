package com.EcommerceApp.ECommerce.Application.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "carts")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToMany
    List<Product> products;

    public Cart() {
        products=new ArrayList<>();
    }
}
