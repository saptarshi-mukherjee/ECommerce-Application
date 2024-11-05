package com.EcommerceApp.ECommerce.Application.Repositories;


import com.EcommerceApp.ECommerce.Application.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {

    @Query(value = "select prod.name\n" +
            "from users as u\n" +
            "join carts_products as cp\n" +
            "on u.cart_id=cp.carts_id\n" +
            "join products as prod\n" +
            "on cp.products_id=prod.id\n" +
            "where u.name=:name", nativeQuery = true)
    public List<Object[]> fetchCartOfUser(@Param("name") String name);

    @Query(value = "select prod.name\n" +
            "from users as u\n" +
            "join carts_products as cp\n" +
            "on u.cart_id=cp.carts_id\n" +
            "join products as prod\n" +
            "on cp.products_id=prod.id\n" +
            "where u.name=:name", nativeQuery = true)
    public List<Object[]> fetchCartOfUserByName(@Param("name") String name);

    @Query(value = "select cart_id\n" +
            "from users\n" +
            "where name=:user_name", nativeQuery = true)
    public Long fetchCartId(@Param("user_name") String user_name);
}
