package com.catgok.interfaces;

import com.catgok.application.services.FoodService;
import com.catgok.domain.Food.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/FoodController")
public class FoodInterface {
    @Autowired
    FoodService foodService;

    @GetMapping("/ping")
    public String ping() {
        return "food";
    }

    @RequestMapping("/listFoodByBusinessId")
    public List<Food> listFoodByBusinessId(Food food) throws Exception {
        return foodService.listFoodByBusinessId(food.getBusinessId());
    }

    @RequestMapping("/getFoodById")
    public Food getFoodById(Integer foodId) {
        return foodService.getFoodById(foodId);
    }
}