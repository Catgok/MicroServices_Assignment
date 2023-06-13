package com.catgok.application.services;

import com.catgok.domain.Business.entity.Business;

import java.util.List;

public interface BusinessService {
    List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    Business getBusinessById(Integer businessId);
}
