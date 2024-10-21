package com.EcommerceApp.ECommerce.Application.Controller;


import com.EcommerceApp.ECommerce.Application.DTO.ProductRequestDto;
import com.EcommerceApp.ECommerce.Application.Models.Product;
import com.EcommerceApp.ECommerce.Application.Projections.ProductResponse;
import com.EcommerceApp.ECommerce.Application.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService prod_serve;

    @PostMapping("/post")
    public Product createProduct(@RequestBody ProductRequestDto post_req) {
        return prod_serve.addProduct(post_req.getName(), post_req.getCategory(), post_req.getQuantity(), post_req.getPrice());
    }

    @GetMapping("/get/{id}")
    public ProductResponse getProductById(@PathVariable("id") Long id) {
        return prod_serve.productByID(id);
    }
}
