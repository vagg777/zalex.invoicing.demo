package com.example.zalexinvoicingdemo.service;

import com.example.zalexinvoicingdemo.dto.CustomerDto;
import com.example.zalexinvoicingdemo.dto.InvoiceDto;
import com.example.zalexinvoicingdemo.entity.Customer;
import com.example.zalexinvoicingdemo.entity.Invoice;
import com.example.zalexinvoicingdemo.persistence.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.zalexinvoicingdemo.mapper.Mapper.toCustomerDto;
import static com.example.zalexinvoicingdemo.mapper.Mapper.toInvoiceDto;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public InvoiceDto saveInvoice(Invoice invoice) {
        return toInvoiceDto(invoiceRepository.save(invoice), false);
    }

    @Override
    public List<InvoiceDto> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<InvoiceDto> invoicesDtos = new ArrayList<>();
        for (Invoice invoice : invoices) {
            invoicesDtos.add(toInvoiceDto(invoice, false));
        }
        return invoicesDtos;

    }

    @Override
    public InvoiceDto getInvoiceById(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return toInvoiceDto(invoice.orElse(null), false);
    }

    @Override
    public InvoiceDto updateInvoice(Long id, Invoice invoiceDetails) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            Invoice existingInvoice = invoice.get();
            existingInvoice.setDateCreated(invoiceDetails.getDateCreated());
            existingInvoice.setCustomer(invoiceDetails.getCustomer());
            existingInvoice.setItems(invoiceDetails.getItems());
            return toInvoiceDto(invoiceRepository.save(existingInvoice), false);
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
