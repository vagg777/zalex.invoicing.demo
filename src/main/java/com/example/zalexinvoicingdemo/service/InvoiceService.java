package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.dto.InvoiceDto;
import com.example.zalexinvoicingdemo.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    InvoiceDto saveInvoice(Invoice invoice);
    List<InvoiceDto> getAllInvoices();
    InvoiceDto getInvoiceById(Long id);
    InvoiceDto updateInvoice(Long id, Invoice invoiceDetails);
    boolean deleteInvoice(Long id);
}
