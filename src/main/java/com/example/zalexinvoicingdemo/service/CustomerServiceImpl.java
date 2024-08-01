package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.dto.CustomerDto;
import com.example.zalexinvoicingdemo.entity.Customer;
import com.example.zalexinvoicingdemo.persistence.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.zalexinvoicingdemo.mapper.Mapper.toCustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto saveCustomer(Customer customer) {
        return toCustomerDto(customerRepository.save(customer));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            customerDtos.add(toCustomerDto(customer));
        }
        return customerDtos;
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return toCustomerDto(customer.orElse(null));
    }

    @Override
    public CustomerDto updateCustomer(Long id, Customer customerDetails) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
            existingCustomer.setFirstName(customerDetails.getFirstName());
            existingCustomer.setMiddleName(customerDetails.getMiddleName());
            existingCustomer.setLastName(customerDetails.getLastName());
            existingCustomer.setAddress(customerDetails.getAddress());
            existingCustomer.setPhone(customerDetails.getPhone());
            return toCustomerDto(customerRepository.save(existingCustomer));
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
