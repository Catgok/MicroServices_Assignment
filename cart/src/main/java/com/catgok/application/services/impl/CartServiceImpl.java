package com.catgok.application.services.impl;

import com.catgok.application.services.CartService;
import com.catgok.domain.Cart.entity.Cart;
import com.catgok.domain.Cart.service.CartDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDomainService cartDomainService;

    @Override
    public List<Cart> listCart(Cart cart) {
        return cartDomainService.listCart(cart);
    }

    @Override
    public int saveCart(Cart cart) {
        return cartDomainService.saveCart(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        return cartDomainService.updateCart(cart);
    }

    @Override
    public int removeCart(Cart cart) {
        return cartDomainService.removeCart(cart);
    }

    @Override
    public int delete(String userId, Integer businessId) {
        return cartDomainService.deleteCart(userId,businessId);
    }
}
