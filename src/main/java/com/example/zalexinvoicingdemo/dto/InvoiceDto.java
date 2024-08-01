package com.example.zalexinvoicingdemo.dto;

import java.time.LocalDate;
import java.util.List;

public class InvoiceDto {
    private Long number;
    private LocalDate dateCreated;
    private CustomerDto customer;
    private List<InvoiceDetailsDto> items;
    private double totalAmount;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public List<InvoiceDetailsDto> getItems() {
        return items;
    }

    public void setItems(List<InvoiceDetailsDto> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
