package com.EcommerceApp.ECommerce.Application.Service;


import com.EcommerceApp.ECommerce.Application.DTO.OrderResponseDto;
import com.EcommerceApp.ECommerce.Application.Models.Order;

import java.util.List;

public interface OrderService {
    public OrderResponseDto placeOrder(String user_name);
    public List<OrderResponseDto> allOrders(String user_name);
}
