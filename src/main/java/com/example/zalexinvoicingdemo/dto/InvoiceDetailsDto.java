package com.example.zalexinvoicingdemo.dto;

import com.example.zalexinvoicingdemo.entity.Invoice;
import com.example.zalexinvoicingdemo.entity.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class InvoiceDetailsDto {
    private Long id;
    private ProductDto product;
    private int quantity;
    private InvoiceDto invoice;
    private double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
