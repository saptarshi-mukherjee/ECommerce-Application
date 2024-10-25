package com.EcommerceApp.ECommerce.Application.Service;


import com.EcommerceApp.ECommerce.Application.Models.User;
import com.EcommerceApp.ECommerce.Application.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo user_repo;

    @Override
    public User addUser(String name, String email, String phone, String address) {
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user=user_repo.save(user);
        return user;
    }

    @Override
    public List<User> allUsers() {
        List<User> user_list=user_repo.fetchAllUsers();
        return user_list;
    }
}
