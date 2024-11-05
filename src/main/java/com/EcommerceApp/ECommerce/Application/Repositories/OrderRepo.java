package com.EcommerceApp.ECommerce.Application.Repositories;


import com.EcommerceApp.ECommerce.Application.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
}
