package com.catgok.application.services;

import com.catgok.domain.Cart.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> listCart(Cart cart);

    int saveCart(Cart cart);

    int updateCart(Cart cart);

    int removeCart(Cart cart);

    int delete(String userId, Integer businessId);
}
