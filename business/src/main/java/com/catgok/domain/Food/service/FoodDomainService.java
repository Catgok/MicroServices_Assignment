package com.catgok.domain.Food.service;

import com.catgok.domain.Food.entity.Food;
import com.catgok.domain.Food.repository.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodDomainService {
    @Autowired
    FoodDao foodDao;

    public List<Food> listFoodByBusinessId(Integer businessId) {
        return foodDao.getFoodsByBusinessId(businessId);
    }

    public Food getFoodById(Integer foodId) {
        return foodDao.getFoodByFoodId(foodId);
    }
}
