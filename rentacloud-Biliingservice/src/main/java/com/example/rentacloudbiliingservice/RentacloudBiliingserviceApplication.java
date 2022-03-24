package com.example.rentacloudbiliingservice;

import com.example.rentacloudbiliingservice.dto.InvoiceRequestDTO;
import com.example.rentacloudbiliingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class RentacloudBiliingserviceApplication {

    public static void main(String[] args) {

        SpringApplication.run(RentacloudBiliingserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(9800),"C01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(543029),"C01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(60000),"C02"));



        };
    }

}
