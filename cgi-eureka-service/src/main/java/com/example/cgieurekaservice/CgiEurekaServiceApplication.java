package com.example.cgieurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CgiEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgiEurekaServiceApplication.class, args);
    }

}
