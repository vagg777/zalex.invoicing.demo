package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.dto.ProductDto;
import com.example.zalexinvoicingdemo.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(Product product);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto updateProduct(Long id, Product productDetails);
    boolean deleteProduct(Long id);
}

