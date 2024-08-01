package com.example.zalexinvoicingdemo.service;


import com.example.zalexinvoicingdemo.dto.InvoiceDto;
import com.example.zalexinvoicingdemo.dto.ProductDto;
import com.example.zalexinvoicingdemo.entity.Invoice;
import com.example.zalexinvoicingdemo.entity.Product;
import com.example.zalexinvoicingdemo.persistence.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.zalexinvoicingdemo.mapper.Mapper.toInvoiceDto;
import static com.example.zalexinvoicingdemo.mapper.Mapper.toProductDto;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto saveProduct(Product product) {
        return toProductDto(productRepository.save(product));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(toProductDto(product));
        }
        return productDtos;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return toProductDto(product.orElse(null));
    }

    @Override
    public ProductDto updateProduct(Long id, Product productDetails) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product existingProduct = product.get();
            existingProduct.setName(productDetails.getName());
            existingProduct.setModelNumber(productDetails.getModelNumber());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setPrice(productDetails.getPrice());
            return toProductDto(productRepository.save(existingProduct));
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        } else {
            return false;
        }
    }
}