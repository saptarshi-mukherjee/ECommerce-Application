package com.EcommerceApp.ECommerce.Application.Controller;


import com.EcommerceApp.ECommerce.Application.DTO.CartRequestDto;
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
    public CartResponse addProductToCart(@RequestBody CartRequestDto cart_req) {
        return cart_serve.addToCart(cart_req.getUser_name(),cart_req.getProduct_name());
    }

    @GetMapping("/get")
    public List<String> getCartOfUser(@RequestParam("id") long id, @RequestParam("name") String name) {
        return cart_serve.itemsInCart(id,name);
    }
}
