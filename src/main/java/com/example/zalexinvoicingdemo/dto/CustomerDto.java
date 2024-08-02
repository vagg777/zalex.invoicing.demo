package com.example.zalexinvoicingdemo.dto;

import java.util.List;

public class CustomerDto {

    private Long accountNo;

    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String phone;
    private List<InvoiceDto> invoices;
    private double accountBalance; // Add this field


    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<InvoiceDto> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceDto> invoices) {
        this.invoices = invoices;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        double balance = 0.0;
        if (invoices != null) {
            for (InvoiceDto invoice : invoices) {
                balance += invoice.getTotalAmount();
            }
        }
        this.accountBalance = balance;
    }

}
