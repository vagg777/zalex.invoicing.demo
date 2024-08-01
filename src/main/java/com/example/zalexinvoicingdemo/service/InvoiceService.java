package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice saveInvoice(Invoice invoice);
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(Long id);
    Invoice updateInvoice(Long id, Invoice invoiceDetails);
    boolean deleteInvoice(Long id);
}
