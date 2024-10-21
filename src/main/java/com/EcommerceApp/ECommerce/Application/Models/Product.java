package com.EcommerceApp.ECommerce.Application.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "products")
@Data
public class Product {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String category;
    int quantity;
    double price;
}
