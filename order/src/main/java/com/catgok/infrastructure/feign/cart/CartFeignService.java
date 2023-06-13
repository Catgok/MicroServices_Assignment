package com.catgok.infrastructure.feign.cart;

import com.catgok.domain.Order.entity.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "cart")
public interface CartFeignService {
    @RequestMapping("/elm/CartController/listCart")
    public List<Cart> listCart(@RequestBody Cart cart);

    @RequestMapping("/elm/CartController/delete")
    public int removeCartByUserIdAndBusinessId(@RequestParam(name="userId") String userId, @RequestParam(name="businessId") Integer businessId);
}
