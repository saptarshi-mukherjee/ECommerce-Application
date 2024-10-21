package com.EcommerceApp.ECommerce.Application.Repositories;


import com.EcommerceApp.ECommerce.Application.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo  extends JpaRepository<Product,Long> {

    @Query(value = "select *\n" +
            "from products \n" +
            "where id=:id", nativeQuery = true)
    public Product fetchById(@Param("id") Long id);
}
