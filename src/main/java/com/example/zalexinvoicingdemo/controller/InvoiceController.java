package com.example.zalexinvoicingdemo.controller;

import com.example.zalexinvoicingdemo.dto.InvoiceDto;
import com.example.zalexinvoicingdemo.entity.Invoice;
import com.example.zalexinvoicingdemo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // Create a new invoice
    @PostMapping
    public InvoiceDto createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    // Get all invoices
    @GetMapping
    public List<InvoiceDto> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Get an invoice by ID
    @GetMapping("/{id}")
    public InvoiceDto getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    // Update an invoice
    @PutMapping("/{id}")
    public InvoiceDto updateInvoice(@PathVariable Long id, @RequestBody Invoice invoiceDetails) {
        return invoiceService.updateInvoice(id, invoiceDetails);
    }

    // Delete an invoice
    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
    }

}