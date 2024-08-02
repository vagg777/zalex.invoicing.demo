package com.example.zalexinvoicingdemo.dto;

import java.time.LocalDate;
import java.util.List;

public class InvoiceDto {
    private Long number;
    private LocalDate dateCreated;
    private Long customerId; // Only the ID to solve recursion problem

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

    public List<InvoiceDetailsDto> getItems() {
        return items;
    }

    public void setItems(List<InvoiceDetailsDto> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
