package com.catgok.domain.Cart.service;

import com.catgok.domain.Cart.entity.Business;
import com.catgok.domain.Cart.entity.Cart;
import com.catgok.domain.Cart.repository.CartPo;
import com.catgok.infrastructure.feign.business.BusinessFeignService;
import com.catgok.infrastructure.loadbalance.LoadBalanceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.stereotype.Service;

@Service
@LoadBalancerClient(name = "business", configuration = LoadBalanceConfiguration.class)
public class CartFactory {
    @Autowired
    BusinessFeignService businessFeignService;

    public CartPo createCartPO(Cart cart) {
        CartPo cartPo = new CartPo();
        cartPo.setUserId(cart.getUserId());
        cartPo.setCartId(cart.getCartId());
        cartPo.setFoodId(cart.getFoodId());
        cartPo.setBusinessId(cart.getBusinessId());
        cartPo.setQuantity(cart.getQuantity());
        return cartPo;
    }

    public Cart createCart(CartPo cartPo) {
        Cart cart = new Cart();
        cart.setUserId(cartPo.getUserId());
        cart.setCartId(cartPo.getCartId());
        cart.setFoodId(cartPo.getFoodId());
        cart.setBusinessId(cartPo.getBusinessId());
        cart.setQuantity(cartPo.getQuantity());
        cart.setFood(businessFeignService.getFoodById(cartPo.getFoodId()));
        Business business = new Business();
        business.setBusinessId(cartPo.getBusinessId());
        cart.setBusiness(businessFeignService.getBusinessById(business));
        return cart;
    }
}
