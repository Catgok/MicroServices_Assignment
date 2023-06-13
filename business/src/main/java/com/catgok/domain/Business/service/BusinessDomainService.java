package com.catgok.domain.Business.service;

import com.catgok.domain.Business.entity.Business;
import com.catgok.domain.Business.repository.BusinessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessDomainService {
    @Autowired
    BusinessDao businessDao;

    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessDao.getBusinessesByOrderTypeId(orderTypeId);
    }

    public Business getBusinessById(Integer businessId) {
        return businessDao.getBusinessesByBusinessId(businessId);
    }
}
