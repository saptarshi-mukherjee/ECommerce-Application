package com.EcommerceApp.ECommerce.Application.Service;


import com.EcommerceApp.ECommerce.Application.Models.Cart;
import com.EcommerceApp.ECommerce.Application.Models.Product;
import com.EcommerceApp.ECommerce.Application.Models.User;
import com.EcommerceApp.ECommerce.Application.Projections.CartInfo;
import com.EcommerceApp.ECommerce.Application.Projections.CartResponse;
import com.EcommerceApp.ECommerce.Application.Repositories.CartRepo;
import com.EcommerceApp.ECommerce.Application.Repositories.ProductRepo;
import com.EcommerceApp.ECommerce.Application.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    public List<CartInfo> addToCart(String name, String prod_name) {
        User user=user_repo.fetchUserByName(name);
        Product product=prod_repo.fetchByName(prod_name);
        user.getCart().getProducts().add(product);
        //manually save the updated cart
        cart_repo.save(user.getCart());
        return itemsInCart(name);
    }

    @Override
    public List<CartInfo> itemsInCart(String name) {
        List<String> items=new ArrayList<>();
        List<Object[]> cart_items=cart_repo.fetchCartOfUser(name);
        for(Object[] obj : cart_items) {
            items.add((String)obj[0]);
        }
        HashMap<String,Integer> map=putInMap(items);
        HashSet<String> set=new HashSet<>();
        List<CartInfo> cart_info_list=new ArrayList<>();
        for(String item : items) {
            if(!set.contains(item)) {
                CartInfo cart_info = new CartInfo();
                cart_info.setProduct_name(item);
                cart_info.setQuantity(map.get(item));
                cart_info_list.add(cart_info);
                set.add(item);
            }
        }
        return cart_info_list;
    }

    private HashMap<String, Integer> putInMap(List<String> items) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(String item : items) {
            if(!map.containsKey(item))
                map.put(item,1);
            else
                map.put(item, map.get(item)+1);
        }
        return map;
    }

    @Override
    public List<CartInfo> removeFromCart(String user_name, String prod_name) {
        User user=user_repo.fetchUserByName(user_name);
        int index=-1;
        for(int i=0;i<user.getCart().getProducts().size();i++) {
            if(user.getCart().getProducts().get(i).getName().equalsIgnoreCase(prod_name)) {
                index=i;
                break;
            }
        }
        user.getCart().getProducts().remove(index);
        cart_repo.save(user.getCart());
        List<CartInfo> cart_info_list=itemsInCart(user_name);
        return cart_info_list;
    }


}
