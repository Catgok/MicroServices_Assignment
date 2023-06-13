package com.catgok.domain.User.repository;

import com.catgok.domain.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
    public User getUserByUserIdAndPassword(String Id, String password);

    public User getUserByUserId(String userId);
}
