package com.catgok.application.services.impl;

import com.catgok.application.services.BusinessService;
import com.catgok.domain.Business.entity.Business;
import com.catgok.domain.Business.service.BusinessDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessDomainService businessDomainService;

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessDomainService.listBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return businessDomainService.getBusinessById(businessId);
    }
}
