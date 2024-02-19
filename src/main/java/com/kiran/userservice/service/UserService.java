package com.kiran.userservice.service;

import com.kiran.userservice.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> listUsers();
    User getUser(String userId);
}
