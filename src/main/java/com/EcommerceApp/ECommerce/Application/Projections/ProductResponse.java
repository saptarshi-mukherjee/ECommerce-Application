package com.EcommerceApp.ECommerce.Application.Projections;


import lombok.Data;

@Data
public class ProductResponse {
    long id;
    String name, category;
    double price;
}
