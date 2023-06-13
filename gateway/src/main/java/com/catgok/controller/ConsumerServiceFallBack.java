package com.catgok.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerServiceFallBack {
    @RequestMapping("/gatewayFallBack")
    public String callFallBack() {
        return "404";
    }
}
