package com.catgok.application.services;

import com.catgok.domain.Food.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> listFoodByBusinessId(Integer businessId);
    Food getFoodById(Integer foodId);
}
