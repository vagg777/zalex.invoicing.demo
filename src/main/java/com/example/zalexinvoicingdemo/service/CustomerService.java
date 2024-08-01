package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer updateCustomer(Long id, Customer customerDetails);
    boolean deleteCustomer(Long id);
}
