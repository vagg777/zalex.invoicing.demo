package com.example.zalexinvoicingdemo.persistence;

import com.example.zalexinvoicingdemo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
