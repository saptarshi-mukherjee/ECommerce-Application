package com.EcommerceApp.ECommerce.Application.DTO;


import lombok.Data;

@Data
public class UpdateProductRequestDto {
    long id;
    String name, category;
    int quantity;
    double price;
}
