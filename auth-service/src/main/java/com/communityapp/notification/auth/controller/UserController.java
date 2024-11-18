package com.communityapp.notification.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.communityapp.notification.auth.model.User;
import com.communityapp.notification.auth.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode the password
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
