package com.communityapp.notification.auth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.communityapp.notification.auth.model.User;
import com.communityapp.notification.auth.repository.UserRepository;
import com.communityapp.notification.auth.service.AuthService;
import com.communityapp.notification.auth.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Welcome";
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return authService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        String token = authService.validateUser(user);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public Optional<User> getUserByEmail(@PathVariable String username) {
        return authService.findByUsername(username);
    }

    @PostMapping("/validate/token")
    public ResponseEntity<?> validateToken(@RequestParam String token) {
        return new ResponseEntity<>(authService.validateToken(token), HttpStatus.OK);
    }
}
