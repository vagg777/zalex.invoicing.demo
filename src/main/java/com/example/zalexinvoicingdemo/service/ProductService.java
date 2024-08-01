package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product productDetails);
    boolean deleteProduct(Long id);
}

