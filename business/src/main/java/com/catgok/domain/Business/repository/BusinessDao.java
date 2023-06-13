package com.catgok.domain.Business.repository;

import com.catgok.domain.Business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessDao extends JpaRepository<Business, Integer> {
    public List<Business> getBusinessesByOrderTypeId(Integer orderTypeId);

    public Business getBusinessesByBusinessId(Integer businessId);
}
