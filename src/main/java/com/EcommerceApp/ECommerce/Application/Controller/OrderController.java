package com.EcommerceApp.ECommerce.Application.Controller;


import com.EcommerceApp.ECommerce.Application.DTO.OrderResponseDto;
import com.EcommerceApp.ECommerce.Application.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService order_serve;

    @PostMapping("/post/{user_name}")
    public OrderResponseDto buyNow(@PathVariable("user_name") String user_name){
        return order_serve.placeOrder(user_name);
    }

    @GetMapping("/get")
    public OrderResponseDto getParticularOrder(@RequestParam("user_name") String user_name, @RequestParam("order_id") long order_id) {
        return order_serve.orderInfo(user_name, order_id);
    }

    @GetMapping("/get/all/{user_name}")
    public List<OrderResponseDto> getAllOrders(@PathVariable("user_name") String user_name) {
        return order_serve.allOrders(user_name);
    }
}
