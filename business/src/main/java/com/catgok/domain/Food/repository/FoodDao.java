package com.catgok.domain.Food.repository;

import com.catgok.domain.Food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodDao extends JpaRepository<Food, Integer> {
    public List<Food> getFoodsByBusinessId(Integer businessId);

    public Food getFoodByFoodId(Integer foodId);
}
