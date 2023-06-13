package com.catgok.application.services.impl;

import com.catgok.application.services.FoodService;
import com.catgok.domain.Food.entity.Food;
import com.catgok.domain.Food.service.FoodDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodDomainService foodDomainService;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        return foodDomainService.listFoodByBusinessId(businessId);
    }

    @Override
    public Food getFoodById(Integer foodId) {
        return foodDomainService.getFoodById(foodId);
    }
}