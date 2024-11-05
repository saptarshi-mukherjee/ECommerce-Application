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
    public OrderResponseDto orderInfo(String user_name, long order_id) {
        OrderResponseDto order_response=new OrderResponseDto();
        List<Object[]> orders=order_repo.fetchAllOrders(user_name,order_id);
        order_response.setDelivery_address((String) orders.get(0)[0]);
        order_response.setDate((String)orders.get(0)[1]);
        order_response.setOrder_value((Double)orders.get(0)[2]);
        List<String> prod=new ArrayList<>();
        for(Object[] obj : orders) {
            prod.add((String)obj[3]);
        }
        order_response.setProd_name(prod);
        return order_response;
    }

    @Override
    public List<OrderResponseDto> allOrders(String user_name) {
        List<Object[]> order_id_list=order_repo.fetchAllOrderIds(user_name);
        List<OrderResponseDto> order_response_list=new ArrayList<>();
        for(Object[] id : order_id_list) {
            OrderResponseDto order_response=orderInfo(user_name, (Long)id[0]);
            order_response_list.add(order_response);
        }
        return order_response_list;
    }
}
