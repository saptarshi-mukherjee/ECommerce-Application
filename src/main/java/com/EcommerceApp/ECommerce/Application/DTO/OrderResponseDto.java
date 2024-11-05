package com.EcommerceApp.ECommerce.Application.DTO;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderResponseDto {
    String date;
    String delivery_address;
    double order_value;
    List<String> prod_name;

    public OrderResponseDto() {
        prod_name=new ArrayList<>();
    }
}
