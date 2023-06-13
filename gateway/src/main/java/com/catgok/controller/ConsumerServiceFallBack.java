package com.catgok.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerServiceFallBack {
    @GetMapping("/addCartGatewayFallBack")
    public String callFallBack() {
        return "404";
    }
}
