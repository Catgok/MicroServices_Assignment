package com.catgok.interfaces;

import com.catgok.application.services.CartService;
import com.catgok.domain.Cart.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/CartController")
public class CartInterface {
    @Autowired
    private CartService cartService;

    @GetMapping("/ping")
    public String ping() {
        return "cart";
    }

    @RequestMapping("/listCart")
    public List<Cart> listCart(@RequestBody Cart cart) throws Exception {
        return cartService.listCart(cart);
    }

    @RequestMapping("/saveCart")
    public int saveCart(@RequestBody Cart cart) throws Exception {
        return cartService.saveCart(cart);
    }

    @RequestMapping("/updateCart")
    public int updateCart(Cart cart) throws Exception {
        return cartService.updateCart(cart);
    }

    @RequestMapping("/removeCart")
    public int removeCart(@RequestBody Cart cart) throws Exception {
        return cartService.removeCart(cart);
    }
    @RequestMapping("/delete")
    public int deleteCart(String userId, Integer businessId){
        return cartService.delete(userId,businessId);
    }
}
