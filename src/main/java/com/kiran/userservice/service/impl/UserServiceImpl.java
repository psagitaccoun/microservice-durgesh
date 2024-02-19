package com.kiran.userservice.service.impl;

import com.kiran.userservice.entity.User;
import com.kiran.userservice.exception.ResourceNotFoundException;
import com.kiran.userservice.repository.UserRepository;
import com.kiran.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String response = UUID.randomUUID().toString();
        user.setUId(response);
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found in server!!" + userId)

        );
        return user;
    }


}
