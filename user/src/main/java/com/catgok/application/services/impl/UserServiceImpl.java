package com.catgok.application.services.impl;

import com.catgok.application.services.UserService;
import com.catgok.domain.User.entity.User;
import com.catgok.domain.User.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDomainService userDomainService;

    @Override
    public User getUserByIdByPass(User user) {
        return userDomainService.getUserByIdByPass(user);
    }

    @Override
    public int getUserById(String userId) {
        return userDomainService.getUserById(userId);
    }

    @Override
    public int saveUser(User user) {
        return userDomainService.saveUser(user);
    }
}