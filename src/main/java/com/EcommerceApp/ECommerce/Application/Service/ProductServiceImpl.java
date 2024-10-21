package com.EcommerceApp.ECommerce.Application.Service;


import com.EcommerceApp.ECommerce.Application.Models.Product;
import com.EcommerceApp.ECommerce.Application.Projections.ProductResponse;
import com.EcommerceApp.ECommerce.Application.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
