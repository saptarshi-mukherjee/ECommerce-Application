package com.EcommerceApp.ECommerce.Application.Controller;


import com.EcommerceApp.ECommerce.Application.DTO.OrderResponseDto;
import com.EcommerceApp.ECommerce.Application.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService order_serve;

    @PostMapping("/post/{user_name}")
    public OrderResponseDto buyNow(@PathVariable("user_name") String user_name){
        return order_serve.placeOrder(user_name);
    }
}
