package com.EcommerceApp.ECommerce.Application.Service;

import com.EcommerceApp.ECommerce.Application.Models.Product;
import com.EcommerceApp.ECommerce.Application.Projections.ProductResponse;
import com.EcommerceApp.ECommerce.Application.Repositories.ProductRepo;

public interface ProductService {
    public Product addProduct(String name, String category, int quantity, double price);
    public ProductResponse productByID(long id);
}
