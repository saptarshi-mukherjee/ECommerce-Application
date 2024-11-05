package com.EcommerceApp.ECommerce.Application.Models;


import com.EcommerceApp.ECommerce.Application.DTO.DateResponseDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    double order_value;
    String order_date;
    String delivery_address;
    @ManyToOne
    User user;
    @ManyToMany
    List<Product> purchased_product;

    public Order() {
        purchased_product=new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getOrder_value() {
        return order_value;
    }

    public void setOrder_value(double order_value) {
        this.order_value = order_value;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getPurchased_product() {
        return purchased_product;
    }

    public void setPurchased_product(List<Product> purchased_product) {
        this.purchased_product = purchased_product;
    }

    public void setOrder_date() {
        String url="https://api.timezonedb.com/v2.1/get-time-zone?key=BVBLF0SNRB9F&format=json&by=zone&zone=Asia/Kolkata";
        RestTemplate rest=new RestTemplate();
        DateResponseDto date_dto=rest.getForObject(url, DateResponseDto.class);
        this.order_date=date_dto.getFormatted();
    }
}
