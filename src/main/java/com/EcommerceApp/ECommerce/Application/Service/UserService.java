package com.EcommerceApp.ECommerce.Application.Service;

import com.EcommerceApp.ECommerce.Application.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public User addUser(String name, String email, String phone, String address);
    public List<User> allUsers();
    public User userByEmail(String email);
    public User updateUser(long id, String name, String email, String phone, String address);
    public boolean deleteUser(String email);
}
