package com.example.zalexinvoicingdemo.controller;

import com.example.zalexinvoicingdemo.entity.Customer;
import com.example.zalexinvoicingdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create a new customer
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get a customer by ID
    @GetMapping("/{accountNo}")
    public Customer getCustomerById(@PathVariable Long accountNo) {
        return customerService.getCustomerById(accountNo);
    }

    // Update a customer
    @PutMapping("/{accountNo}")
    public Customer updateCustomer(@PathVariable Long accountNo, @RequestBody Customer customerDetails) {
        return customerService.updateCustomer(accountNo, customerDetails);
    }

    @DeleteMapping("/{accountNo}")
    public void deleteCustomer(@PathVariable Long accountNo) {
        customerService.deleteCustomer(accountNo);
    }
}