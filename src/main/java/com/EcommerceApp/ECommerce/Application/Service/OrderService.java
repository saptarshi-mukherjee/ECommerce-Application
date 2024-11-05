package com.EcommerceApp.ECommerce.Application.Service;


import com.EcommerceApp.ECommerce.Application.DTO.OrderResponseDto;

import java.util.List;

public interface OrderService {
    public OrderResponseDto placeOrder(String user_name);
    public OrderResponseDto orderInfo(String user_name, long order_id);
    public List<OrderResponseDto> allOrders(String user_name);
}
