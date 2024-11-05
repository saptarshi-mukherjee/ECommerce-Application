package com.EcommerceApp.ECommerce.Application.Service;


import com.EcommerceApp.ECommerce.Application.DTO.OrderResponseDto;
import com.EcommerceApp.ECommerce.Application.Models.Order;
import com.EcommerceApp.ECommerce.Application.Models.Product;
import com.EcommerceApp.ECommerce.Application.Models.User;
import com.EcommerceApp.ECommerce.Application.Projections.CartInfo;
import com.EcommerceApp.ECommerce.Application.Repositories.CartRepo;
import com.EcommerceApp.ECommerce.Application.Repositories.OrderRepo;
import com.EcommerceApp.ECommerce.Application.Repositories.ProductRepo;
import com.EcommerceApp.ECommerce.Application.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    CartRepo cart_repo;
    @Autowired
    OrderRepo order_repo;
    @Autowired
    ProductRepo prod_repo;
    @Autowired
    UserRepo user_repo;
    @Autowired
    CartService cart_serve;

    @Override
    public OrderResponseDto placeOrder(String user_name) {
        double sum=0;
        User user=user_repo.fetchUserByName(user_name);
        List<CartInfo> cart_list=cart_serve.itemsInCart(user_name);
        Order order=new Order();
        order.setOrder_date();
        order.setUser(user);
        for(CartInfo entry : cart_list) {
            Product product=prod_repo.fetchByName(entry.getProduct_name());
            int qty=entry.getQuantity();
            product.setQuantity(product.getQuantity()-qty);
            sum+=(product.getPrice()*qty);
            order.getPurchased_product().add(product);
            prod_repo.save(product);
        }
        order.setOrder_value(sum);
        order.setDelivery_address(user.getAddress());
        order=order_repo.save(order);
        OrderResponseDto order_response=new OrderResponseDto();
        order_response.setOrder_value(order.getOrder_value());
        order_response.setDate(order.getOrder_date());
        order_response.setDelivery_address(order.getDelivery_address());
        for(Product prod : order.getPurchased_product()) {
            order_response.getProd_name().add(prod.getName());
        }
        user.getCart().setProducts(new ArrayList<Product>());
        cart_repo.save(user.getCart());
        return order_response;
    }

    @Override
    public List<OrderResponseDto> allOrders(String user_name) {
        return List.of();
    }
}
