package com.example.rentacloudbiliingservice.dto;

import com.example.rentacloudbiliingservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor

public class InvoiceRequestDTO {

    private BigDecimal amount;
    private String customerId;

}
