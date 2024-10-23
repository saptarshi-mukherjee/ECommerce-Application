package com.EcommerceApp.ECommerce.Application.Controller;


import com.EcommerceApp.ECommerce.Application.DTO.ProductRequestDto;
import com.EcommerceApp.ECommerce.Application.DTO.UpdateProductRequestDto;
import com.EcommerceApp.ECommerce.Application.Models.Product;
import com.EcommerceApp.ECommerce.Application.Projections.ProductResponse;
import com.EcommerceApp.ECommerce.Application.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/get")
    public ProductResponse getProductByName(@RequestParam("name") String name) {
        return prod_serve.productByName(name);
    }

    @GetMapping("")
    public List<ProductResponse> getAllProducts() {
        return prod_serve.allProducts();
    }

    @GetMapping("/get/categories")
    public List<ProductResponse> getProductByCategory(@RequestParam("category") String category) {
        return prod_serve.productsByCategory(category);
    }

    @GetMapping("/categories/all")
    public List<String> getAllCategories() {
        return prod_serve.productCategories();
    }

    @DeleteMapping("/delete/{id}")
    public List<ProductResponse> deleteProductById(@PathVariable("id") long id) {
        return prod_serve.deleteProduct(id);
    }

    @PutMapping("/put")
    public Product updateGivenProduct(@RequestBody UpdateProductRequestDto update_prod) {
        return prod_serve.updateProduct(update_prod.getId(),update_prod.getName(),update_prod.getCategory(),update_prod.getQuantity(),update_prod.getPrice());
    }
}
