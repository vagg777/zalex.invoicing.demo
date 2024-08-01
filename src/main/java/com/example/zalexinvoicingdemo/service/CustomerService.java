package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.dto.CustomerDto;
import com.example.zalexinvoicingdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDto saveCustomer(Customer customer);
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(Long id);
    CustomerDto updateCustomer(Long id, Customer customerDetails);
    boolean deleteCustomer(Long id);
}
