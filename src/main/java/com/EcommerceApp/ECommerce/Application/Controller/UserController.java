package com.EcommerceApp.ECommerce.Application.Controller;


import com.EcommerceApp.ECommerce.Application.DTO.UpdateUserRequestDto;
import com.EcommerceApp.ECommerce.Application.DTO.UserRequestDto;
import com.EcommerceApp.ECommerce.Application.Models.User;
import com.EcommerceApp.ECommerce.Application.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService user_serve;

    @PostMapping("/post")
    public User createUser(@RequestBody UserRequestDto user_req) {
        return user_serve.addUser(user_req.getName(), user_req.getEmail(), user_req.getPhone(), user_req.getAddress());
    }

    @GetMapping("/get/all")
    public List<User> getAllUsers() {
        return user_serve.allUsers();
    }

    @GetMapping("/get")
    public User getUserByEmail(@RequestParam("email") String email) {
        return user_serve.userByEmail(email);
    }

    @PutMapping("/put")
    public User updateUserInfo(@RequestBody UpdateUserRequestDto user_req) {
        return user_serve.updateUser(user_req.getId(),user_req.getName(),user_req.getEmail(),user_req.getPhone(),user_req.getAddress());
    }
}
