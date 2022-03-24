package com.example.rentacloudbiliingservice.services;

import com.example.rentacloudbiliingservice.dto.InvoiceRequestDTO;
import com.example.rentacloudbiliingservice.dto.InvoiceResponseDTO;
import com.example.rentacloudbiliingservice.entities.Customer;
import com.example.rentacloudbiliingservice.entities.Invoice;
import com.example.rentacloudbiliingservice.mappers.InvoiceMapper;
import com.example.rentacloudbiliingservice.openfeign.CustomerRestClient;

import com.example.rentacloudbiliingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional

public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }



    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        try{
            Customer customer= customerRestClient.getCustomer(invoiceRequestDTO.getCustomerId());

        }
        catch (Exception e){
            throw e;
        }


        Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());

        Invoice saveInvoice= invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(saveInvoice);

    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {
        Invoice invoice=invoiceRepository.findById(id).get();
        Customer customer= customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);

    }


    @Override
    public List<InvoiceResponseDTO> invoiceByCustomerId(String customerId) {
        List<Invoice> invoices= invoiceRepository.findByCustomerId(customerId);

        return invoices.stream()
                .map(invoice->invoiceMapper.fromInvoice(invoice))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices=invoiceRepository.findAll();
        for (Invoice invoice: invoices) {
            Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);


        }
        return invoices.stream().map(inv->invoiceMapper.fromInvoice(inv)).collect(Collectors.toList());
    }

}
