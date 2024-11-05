package com.EcommerceApp.ECommerce.Application.Repositories;


import com.EcommerceApp.ECommerce.Application.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {

    @Query(value = "select u.address, ord.order_date, ord.order_value, p.name\n" +
            "from users as u\n" +
            "join orders as ord\n" +
            "on u.user_id=ord.user_user_id\n" +
            "join orders_purchased_product as opp\n" +
            "on ord.id=opp.orders_id\n" +
            "join products as p\n" +
            "on opp.purchased_product_id=p.id\n" +
            "where u.name=:user_name and ord.id=:order_id", nativeQuery = true)
    public List<Object[]> fetchAllOrders(@Param("user_name") String user_name, @Param("order_id") long order_id);

    @Query(value = "select distinct ord.id\n" +
            "from users as u\n" +
            "join orders as ord\n" +
            "on u.user_id=ord.user_user_id\n" +
            "join orders_purchased_product as opp\n" +
            "on ord.id=opp.orders_id\n" +
            "join products as p\n" +
            "on opp.purchased_product_id=p.id\n" +
            "where u.name=:user_name", nativeQuery = true)
    public List<Object[]> fetchAllOrderIds(@Param("user_name") String user_name);
}
