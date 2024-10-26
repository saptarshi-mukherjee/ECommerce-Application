package com.EcommerceApp.ECommerce.Application.DTO;


import lombok.Data;

@Data
public class UpdateUserRequestDto {
    long id;
    String name, email, phone, address;
}
