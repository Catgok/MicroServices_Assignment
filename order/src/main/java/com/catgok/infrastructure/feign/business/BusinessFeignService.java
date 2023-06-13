package com.catgok.infrastructure.feign.business;

import com.catgok.domain.Order.entity.Business;
import com.catgok.domain.OrderDetail.entity.Food;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "business")
public interface BusinessFeignService {
    @RequestMapping("/elm/BusinessController/getBusinessById")
    public Business getBusinessById(@RequestBody Business business);

    @RequestMapping("/elm/FoodController/getFoodById")
    public Food getFoodById(@RequestParam(name = "foodId") Integer foodId);
}
