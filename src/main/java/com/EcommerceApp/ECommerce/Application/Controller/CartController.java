package com.EcommerceApp.ECommerce.Application.Controller;


import com.EcommerceApp.ECommerce.Application.DTO.CartRequestDto;
import com.EcommerceApp.ECommerce.Application.Projections.CartInfo;
import com.EcommerceApp.ECommerce.Application.Projections.CartResponse;
import com.EcommerceApp.ECommerce.Application.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    CartService cart_serve;

    @PostMapping("/post")
    public List<CartInfo> addProductToCart(@RequestBody CartRequestDto cart_req) {
        return cart_serve.addToCart(cart_req.getUser_name(),cart_req.getProduct_name());
    }

    @GetMapping("/get")
    public List<CartInfo> getCartOfUser(@RequestParam("name") String name) {
        return cart_serve.itemsInCart(name);
    }

    @DeleteMapping("/delete")
    public List<CartInfo> deleteProductFromCart(@RequestParam("user_name") String user_name, @RequestParam("prod_name") String prod_name) {
        return cart_serve.removeFromCart(user_name,prod_name);
    }
}
