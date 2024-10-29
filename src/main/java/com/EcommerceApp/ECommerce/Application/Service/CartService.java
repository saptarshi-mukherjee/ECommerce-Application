package com.EcommerceApp.ECommerce.Application.Service;

import com.EcommerceApp.ECommerce.Application.Projections.CartResponse;

import java.util.List;

public interface CartService {
    public void createCart();
    public CartResponse addToCart(String name, String prod_name);
    public List<String> itemsInCart(long id, String name);
}
