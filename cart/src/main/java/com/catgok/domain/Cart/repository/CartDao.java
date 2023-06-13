package com.catgok.domain.Cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDao extends JpaRepository<CartPo, Integer> {
    List<CartPo> getCartsByUserIdAndBusinessId(String userId, Integer businessId);

//    @Query("update CartPo set CartPo.quantity=:quantity where CartPo.foodId=:foodId and CartPo.businessId =:businessId and CartPo.userId=:userId")
//    void update(@Param("quantity") Integer quantity, @Param("foodId") Integer foodId, @Param("businessId") Integer businessId, @Param("userId") String userId);

    CartPo getCartPoByFoodIdAndBusinessIdAndUserId(Integer foodId, Integer businessId, String userId);

    List<CartPo> getCartPosByUserIdAndBusinessId(String userId,Integer businessId);
}
