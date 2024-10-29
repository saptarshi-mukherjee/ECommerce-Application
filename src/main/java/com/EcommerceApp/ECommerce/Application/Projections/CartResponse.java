package com.EcommerceApp.ECommerce.Application.Projections;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartResponse {
    String user_name;
    List<String> prod_name;

    public CartResponse() {
        prod_name=new ArrayList<>();
    }
}
