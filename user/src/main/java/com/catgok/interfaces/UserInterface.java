package com.catgok.interfaces;

import com.catgok.application.services.UserService;
import com.catgok.domain.User.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserController")
public class UserInterface {
    @Autowired
    private UserService UserService;

    @GetMapping("/ping")
    public String ping() {
        return "2334213";
    }

    @RequestMapping("/getUserByIdByPass")
    public User getUserByIdByPass(User user) throws Exception {
        return UserService.getUserByIdByPass(user);
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
