package com.example.rentacloudbiliingservice.mappers;

import com.example.rentacloudbiliingservice.dto.InvoiceRequestDTO;
import com.example.rentacloudbiliingservice.dto.InvoiceResponseDTO;
import com.example.rentacloudbiliingservice.entities.Invoice;
import org.mapstruct.Mapper;


@Mapper(componentModel ="spring")
public interface InvoiceMapper {

    //objectif : le trasfert de données
    Invoice fromInvoiceRequestDTO (InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice );

}

