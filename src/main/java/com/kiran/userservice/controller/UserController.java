package com.kiran.userservice.controller;

import com.kiran.userservice.entity.User;
import com.kiran.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
@GetMapping
    public List<User> listUsers(){
        List<User> users = userService.listUsers();
      return users;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable (name="id")String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
}
