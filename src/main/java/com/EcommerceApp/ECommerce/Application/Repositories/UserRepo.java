package com.EcommerceApp.ECommerce.Application.Repositories;


import com.EcommerceApp.ECommerce.Application.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "select * from users", nativeQuery = true)
    public List<User> fetchAllUsers();

    @Query(value = "select * from users\n" +
            "where email= :email", nativeQuery = true)
    public User fetchUserByEmail(@Param("email") String email);

    @Query(value = "select * from users where user_id = :id", nativeQuery = true)
    public User fetchUserById(@Param("id") long id);
}
