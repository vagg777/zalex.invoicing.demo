package com.example.zalexinvoicingdemo.persistence;

import com.example.zalexinvoicingdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
