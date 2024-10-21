package com.EcommerceApp.ECommerce.Application.DTO;


import lombok.Data;

@Data
public class ProductRequestDto {
    String name, category;
    int quantity;
    double price;
}
