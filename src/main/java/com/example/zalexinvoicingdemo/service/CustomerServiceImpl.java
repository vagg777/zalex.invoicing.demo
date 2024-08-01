package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.entity.Customer;
import com.example.zalexinvoicingdemo.persistence.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
            existingCustomer.setFirstName(customerDetails.getFirstName());
            existingCustomer.setMiddleName(customerDetails.getMiddleName());
            existingCustomer.setLastName(customerDetails.getLastName());
            existingCustomer.setAddress(customerDetails.getAddress());
            existingCustomer.setPhone(customerDetails.getPhone());
            return customerRepository.save(existingCustomer);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
            return true;
        } else {
            return false;
        }
    }
}
