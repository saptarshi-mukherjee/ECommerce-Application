package com.EcommerceApp.ECommerce.Application.Projections;


import lombok.Data;

@Data
public class CartInfo {
    String product_name;
    int quantity;
}
