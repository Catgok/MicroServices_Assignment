package com.catgok.domain.Cart.service;

import com.catgok.domain.Cart.entity.Cart;
import com.catgok.domain.Cart.repository.CartDao;
import com.catgok.domain.Cart.repository.CartPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartDomainService {
    @Autowired
    CartDao cartDao;

    @Autowired
    CartFactory cartFactory;

    public List<Cart> listCart(Cart cart) {
        List<CartPo> cartPos = cartDao.getCartsByUserIdAndBusinessId(cart.getUserId(), cart.getBusinessId());
        List<Cart> carts = new ArrayList<>();
        for (CartPo cartPo : cartPos) carts.add(cartFactory.createCart(cartPo));
        return carts;
    }

    public int saveCart(Cart cart) {
        try {
            cart.setQuantity(1);
            cartDao.save(cartFactory.createCartPO(cart));
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateCart(Cart cart) {
        try {
            cartDao.delete(cartDao.getCartPoByFoodIdAndBusinessIdAndUserId(cart.getFoodId(), cart.getBusinessId(), cart.getUserId()));
            cartDao.save(cartFactory.createCartPO(cart));
//            cartDao.update(cart.getQuantity(), cart.getFoodId(), cart.getBusinessId(), cart.getUserId());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int removeCart(Cart cart) {
        try {
            cartDao.delete(cartDao.getCartPoByFoodIdAndBusinessIdAndUserId(cart.getFoodId(), cart.getBusinessId(), cart.getUserId()));
//            cartDao.deleteCartPoByFoodIdAndBusinessIdAndUserId(cart.getFoodId(), cart.getBusinessId(), cart.getUserId());
//            cartDao.delete(cart.getFoodId(), cart.getBusinessId(), cart.getUserId());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteCart(String userId, Integer businessId) {
        try {
            List<CartPo> cartPoList = cartDao.getCartPosByUserIdAndBusinessId(userId, businessId);
            cartDao.deleteAll(cartPoList);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
