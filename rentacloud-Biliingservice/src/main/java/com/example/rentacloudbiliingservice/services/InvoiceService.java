package com.example.rentacloudbiliingservice.services;

import com.example.rentacloudbiliingservice.dto.InvoiceRequestDTO;
import com.example.rentacloudbiliingservice.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String id);
    List<InvoiceResponseDTO> invoiceByCustomerId(String customerId);
    List<InvoiceResponseDTO> allInvoices();
}
