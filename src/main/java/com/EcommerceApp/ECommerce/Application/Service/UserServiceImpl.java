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

    @Override
    public User userByEmail(String email) {
        User user=user_repo.fetchUserByEmail(email);
        return user;
    }

    @Override
    public User updateUser(long id, String name, String email, String phone, String address) {
        User user=user_repo.fetchUserById(id);
        if(name!=null)
            user.setName(name);
        if(email!=null)
            user.setEmail(email);
        if(phone!=null)
            user.setPhone(phone);
        if(address!=null)
            user.setAddress(address);
        user=user_repo.save(user);
        return user;
    }

    @Override
    public boolean deleteUser(String email) {
        User user=user_repo.fetchUserByEmail(email);
        if(user!=null) {
            user_repo.delete(user);
            return true;
        }
        return false;
    }
}
