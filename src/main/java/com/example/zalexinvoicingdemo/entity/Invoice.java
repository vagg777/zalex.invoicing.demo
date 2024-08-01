package com.example.zalexinvoicingdemo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetails> items = new ArrayList<>();

    public double getTotalAmount() {
        double totalAmount = 0.0;
        for (InvoiceDetails item : items) {
            totalAmount += item.getAmount();
        }
        return totalAmount;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvoiceDetails> getItems() {
        return items;
    }

    public void setItems(List<InvoiceDetails> items) {
        this.items = items;
    }
}
