package com.EcommerceApp.ECommerce.Application.Service;

import com.EcommerceApp.ECommerce.Application.Projections.CartInfo;

import java.util.List;

public interface CartService {
    public void createCart();
    public List<CartInfo> addToCart(String name, String prod_name);
    public List<CartInfo> itemsInCart(String name);
    public List<CartInfo> removeFromCart(String user_name, String prod_name);
}
