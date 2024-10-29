package com.EcommerceApp.ECommerce.Application.Service;


import com.EcommerceApp.ECommerce.Application.Models.Cart;
import com.EcommerceApp.ECommerce.Application.Models.Product;
import com.EcommerceApp.ECommerce.Application.Models.User;
import com.EcommerceApp.ECommerce.Application.Projections.CartResponse;
import com.EcommerceApp.ECommerce.Application.Repositories.CartRepo;
import com.EcommerceApp.ECommerce.Application.Repositories.ProductRepo;
import com.EcommerceApp.ECommerce.Application.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepo cart_repo;
    @Autowired
    UserRepo user_repo;
    @Autowired
    ProductRepo prod_repo;

    @Override
    public void createCart() {
        Cart cart=new Cart();
        cart_repo.save(cart);
    }

    @Override
    public CartResponse addToCart(String name, String prod_name) {
        User user=user_repo.fetchUserByName(name);
        Product product=prod_repo.fetchByName(prod_name);
        user.getCart().getProducts().add(product);
        //manually save the updated cart
        cart_repo.save(user.getCart());
        CartResponse response=new CartResponse();
        response.setUser_name(user.getName());
        for(Product prod : user.getCart().getProducts())
            response.getProd_name().add(prod.getName());
        return response;
    }

    @Override
    public List<String> itemsInCart(long id, String name) {
        List<String> items=new ArrayList<>();
        List<Object[]> cart_items=cart_repo.fetchCartOfUser(id,name);
        for(Object[] obj : cart_items) {
            items.add((String)obj[0]);
        }
        return items;
    }


}
