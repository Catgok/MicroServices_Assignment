package com.catgok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrderApplication_2 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication_2.class, args);
    }
}
