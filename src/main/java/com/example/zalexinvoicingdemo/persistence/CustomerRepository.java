package com.example.zalexinvoicingdemo.persistence;

import com.example.zalexinvoicingdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}