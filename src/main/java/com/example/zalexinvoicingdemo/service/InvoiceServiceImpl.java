package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.entity.Invoice;
import com.example.zalexinvoicingdemo.persistence.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.orElse(null);
    }

    @Override
    public Invoice updateInvoice(Long id, Invoice invoiceDetails) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            Invoice existingInvoice = invoice.get();
            existingInvoice.setDateCreated(invoiceDetails.getDateCreated());
            existingInvoice.setCustomer(invoiceDetails.getCustomer());
            existingInvoice.setItems(invoiceDetails.getItems());
            return invoiceRepository.save(existingInvoice);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteInvoice(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            invoiceRepository.delete(invoice.get());
            return true;
        } else {
            return false;
        }
    }
}
