package com.catgok.application.services;

import com.catgok.domain.User.entity.User;

public interface UserService {
    User getUserByIdByPass(User user);

    int getUserById(String userId);

    int saveUser(User user);
}