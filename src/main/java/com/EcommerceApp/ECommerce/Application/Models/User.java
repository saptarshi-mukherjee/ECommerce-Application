package com.EcommerceApp.ECommerce.Application.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long user_id;
    String name, email, phone, address;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    Cart cart;
}
