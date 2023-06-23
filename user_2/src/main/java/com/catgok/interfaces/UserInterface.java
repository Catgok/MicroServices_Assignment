package com.catgok.interfaces;

import com.catgok.application.services.UserService;
import com.catgok.domain.User.entity.User;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/UserController")
public class UserInterface {
    @Autowired
    private UserService UserService;

    @Bulkhead(name = "bulkheadA", fallbackMethod = "getUserFallBack", type = Bulkhead.Type.SEMAPHORE)
    @RequestMapping("/getUserByIdByPass")
    public CompletableFuture<User> getUserByIdByPass(User user) throws Exception {
        CompletableFuture<User> result = CompletableFuture.supplyAsync(() -> {
            return UserService.getUserByIdByPass(user);
        });
        return result;
    }

    public CompletableFuture<User> getUserFallBack(User user, Throwable e) {
        e.printStackTrace();
        CompletableFuture<User> result = CompletableFuture.supplyAsync(() -> {
            User u = new User();
            u.setUserId("-1");
            return u;
        });
        return result;
    }

    @RequestMapping("/getUserById")
    public int getUserById(User user) throws Exception {
        return UserService.getUserById(user.getUserId());
    }

    @RequestMapping("/saveUser")
    public int saveUser(@RequestBody User user) throws Exception {
        return UserService.saveUser(user);
    }
}
