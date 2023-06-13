package com.catgok.interfaces;

import com.catgok.application.services.BusinessService;
import com.catgok.domain.Business.entity.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BusinessController")
public class BusinessInterface {
    @Autowired
    BusinessService businessService;

    @GetMapping("/ping")
    public String ping() {
        return "business";
    }

    @RequestMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(Business business) throws Exception {
        return businessService.listBusinessByOrderTypeId(business.getOrderTypeId());
    }

    @RequestMapping("/getBusinessById")
    public Business getBusinessById(@RequestBody Business business) throws Exception {
        return businessService.getBusinessById(business.getBusinessId());
    }
}