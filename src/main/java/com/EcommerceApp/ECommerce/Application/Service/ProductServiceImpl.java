package com.EcommerceApp.ECommerce.Application.Service;


import com.EcommerceApp.ECommerce.Application.Models.Product;
import com.EcommerceApp.ECommerce.Application.Projections.ProductResponse;
import com.EcommerceApp.ECommerce.Application.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo prod_repo;

    @Override
    public Product addProduct(String name, String category, int quantity, double price) {
        Product product=new Product();
        product.setName(name);
        product.setCategory(category);
        product.setQuantity(quantity);
        product.setPrice(price);
        product=prod_repo.save(product);
        return product;
    }

    @Override
    public ProductResponse productByID(long id) {
        Product prod=prod_repo.fetchById(id);
        ProductResponse prod_response=new ProductResponse();
        prod_response.setId(prod.getId());
        prod_response.setName(prod.getName());
        prod_response.setCategory(prod.getCategory());
        prod_response.setPrice(prod.getPrice());
        return prod_response;
    }

    @Override
    public ProductResponse productByName(String name) {
        Product prod=prod_repo.fetchByName(name);
        ProductResponse prod_response=new ProductResponse();
        prod_response.setId(prod.getId());
        prod_response.setName(prod.getName());
        prod_response.setCategory(prod.getCategory());
        prod_response.setPrice((prod.getPrice()));
        return prod_response;
    }

    @Override
    public List<ProductResponse> allProducts() {
        List<Product> prod_list=prod_repo.fetchAll();
        List<ProductResponse> prod_response_list=new ArrayList<>();
        for(Product prod : prod_list) {
            if(prod.getName()!=null) {
                ProductResponse prod_response=new ProductResponse();
                prod_response.setId(prod.getId());
                prod_response.setName(prod.getName());
                prod_response.setCategory(prod.getCategory());
                prod_response.setPrice((prod.getPrice()));
                prod_response_list.add(prod_response);
            }
        }
        return prod_response_list;
    }

    @Override
    public List<ProductResponse> productsByCategory(String category) {
        List<Product> prod_list=prod_repo.fetchByCategory(category);
        List<ProductResponse> prod_response_list=new ArrayList<>();
        for(Product prod : prod_list) {
            if(prod.getName()!=null) {
                ProductResponse prod_response=new ProductResponse();
                prod_response.setId(prod.getId());
                prod_response.setName(prod.getName());
                prod_response.setCategory(prod.getCategory());
                prod_response.setPrice((prod.getPrice()));
                prod_response_list.add(prod_response);
            }
        }
        return prod_response_list;
    }

    @Override
    public List<String> productCategories() {
        List<String> cat_list=prod_repo.fetchAllCategories();
        cat_list.remove(null);
        return cat_list;
    }
}
