package com.example.zalexinvoicingdemo.mapper;

import com.example.zalexinvoicingdemo.dto.CustomerDto;
import com.example.zalexinvoicingdemo.dto.InvoiceDetailsDto;
import com.example.zalexinvoicingdemo.dto.InvoiceDto;
import com.example.zalexinvoicingdemo.dto.ProductDto;
import com.example.zalexinvoicingdemo.entity.Customer;
import com.example.zalexinvoicingdemo.entity.Invoice;
import com.example.zalexinvoicingdemo.entity.InvoiceDetails;
import com.example.zalexinvoicingdemo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static CustomerDto toCustomerDto(Customer customer) {

        CustomerDto dto = new CustomerDto();
        dto.setAccountNo(customer.getAccountNo());
        dto.setFirstName(customer.getFirstName());
        dto.setMiddleName(customer.getMiddleName());
        dto.setLastName(customer.getLastName());
        dto.setAddress(customer.getAddress());
        dto.setPhone(customer.getPhone());

        List<InvoiceDto> invoicesDto = new ArrayList<>();
        if (customer.getInvoices() != null) {
            for (Invoice invoice : customer.getInvoices()) {
                invoicesDto.add(toInvoiceDto(invoice, false));
            }
        }
        dto.setInvoices(invoicesDto);
        dto.setAccountBalance(customer.getAccountBalance());

        return dto;
    }

    public static Customer toCustomerEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setAccountNo(customerDto.getAccountNo());
        customer.setFirstName(customerDto.getFirstName());
        customer.setMiddleName(customerDto.getMiddleName());
        customer.setLastName(customerDto.getLastName());
        customer.setAddress(customerDto.getAddress());
        customer.setPhone(customerDto.getPhone());

        List<Invoice> invoices = new ArrayList<>();
        if (customerDto.getInvoices() != null) {
            for (InvoiceDto invoiceDto : customerDto.getInvoices()) {
                invoices.add(toInvoiceEntity(invoiceDto, false));
            }
        }
        customer.setInvoices(invoices);

        return customer;
    }

    public static InvoiceDto toInvoiceDto(Invoice invoice, boolean includeCustomer) {
        InvoiceDto dto = new InvoiceDto();
        dto.setNumber(invoice.getNumber());
        dto.setDateCreated(invoice.getDateCreated());

        if (includeCustomer && invoice.getCustomer() != null) {
            dto.setCustomer(toCustomerDto(invoice.getCustomer()));
        }

        List<InvoiceDetailsDto> detailsDto = new ArrayList<>();
        if (invoice.getItems() != null) {
            for (InvoiceDetails details : invoice.getItems()) {
                detailsDto.add(toInvoiceDetailsDto(details, false));
            }
        }
        dto.setItems(detailsDto);
        dto.setTotalAmount(invoice.getTotalAmount());
        return dto;
    }

    public static Invoice toInvoiceEntity(InvoiceDto invoiceDto, boolean includeCustomer) {
        Invoice invoice = new Invoice();
        invoice.setNumber(invoiceDto.getNumber());
        invoice.setDateCreated(invoiceDto.getDateCreated());

        if (includeCustomer && invoiceDto.getCustomer() != null) {
            invoice.setCustomer(toCustomerEntity(invoiceDto.getCustomer()));
        }

        List<InvoiceDetails> detailsList = new ArrayList<>();
        if (invoiceDto.getItems() != null) {
            for (InvoiceDetailsDto detailsDto : invoiceDto.getItems()) {
                detailsList.add(toInvoiceDetailsEntity(detailsDto, false));
            }
        }
        invoice.setItems(detailsList);

        return invoice;
    }

    public static InvoiceDetailsDto toInvoiceDetailsDto(InvoiceDetails details, boolean includeInvoice) {
        InvoiceDetailsDto dto = new InvoiceDetailsDto();
        dto.setId(details.getId());
        dto.setProduct(toProductDto(details.getProduct()));
        dto.setQuantity(details.getQuantity());
        dto.setAmount(details.getAmount());

        if (includeInvoice && details.getInvoice() != null) {
            dto.setInvoice(toInvoiceDto(details.getInvoice(), false));
        }

        return dto;
    }

    public static InvoiceDetails toInvoiceDetailsEntity(InvoiceDetailsDto detailsDto, boolean includeInvoice) {
        InvoiceDetails details = new InvoiceDetails();
        details.setId(detailsDto.getId());
        details.setQuantity(detailsDto.getQuantity());
        details.setProduct(toProductEntity(detailsDto.getProduct()));

        if (includeInvoice && detailsDto.getInvoice() != null) {
            details.setInvoice(toInvoiceEntity(detailsDto.getInvoice(), false));
        }

        return details;
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setModelNumber(product.getModelNumber());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());

        return dto;
    }

    public static Product toProductEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setModelNumber(productDto.getModelNumber());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        return product;
    }
}