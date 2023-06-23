package com.catgok.domain.User.service;

import com.catgok.domain.User.entity.User;
import com.catgok.domain.User.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService {
    @Autowired
    UserDao userdao;

    public User getUserByIdByPass(User user) {
        return userdao.getUserByUserIdAndPassword(user.getUserId(), user.getPassword());
    }

    public int getUserById(String userId) {
        User user = userdao.getUserByUserId(userId);
        if (null != user) return 1;
        else return 0;
    }

    public int saveUser(User user) {
        try {
            userdao.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
