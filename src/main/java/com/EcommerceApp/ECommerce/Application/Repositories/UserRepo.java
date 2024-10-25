package com.EcommerceApp.ECommerce.Application.Repositories;


import com.EcommerceApp.ECommerce.Application.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "select * from users", nativeQuery = true)
    public List<User> fetchAllUsers();
}
