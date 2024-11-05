package com.EcommerceApp.ECommerce.Application.Repositories;


import com.EcommerceApp.ECommerce.Application.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo  extends JpaRepository<Product,Long> {

    @Query(value = "select *\n" +
            "from products \n" +
            "where id=:id", nativeQuery = true)
    public Product fetchById(@Param("id") Long id);


    @Query(value = "select * \n" +
            "from products\n" +
            "where name=:name", nativeQuery = true)
    public Product fetchByName(@Param("name") String name);

    @Query(value = "select * from products", nativeQuery = true)
    public List<Product> fetchAll();

    @Query(value = "select * \n" +
            "from products \n" +
            "where category = :category", nativeQuery = true)
    public List<Product> fetchByCategory(@Param("category") String category);

    @Query(value = "select distinct category\n" +
            "from products\n" +
            "order by category", nativeQuery = true)
    public List<String> fetchAllCategories();

    @Query(value = "select * from products \n" +
            "where name=:name and id=:id", nativeQuery = true)
    public Product fetchProductByNameAndId(@Param("name") String name, @Param("id") long id);

    @Query(value = "select id\n" +
            "from products \n" +
            "where name=:prod_name", nativeQuery = true)
    public Long fetchProductId(@Param("prod_name") String prod_name);
}
