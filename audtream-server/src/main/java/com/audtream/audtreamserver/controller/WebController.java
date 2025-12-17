package com.audtream.audtreamserver.controller;

import com.audtream.audtreamserver.model.User;
import com.audtream.audtreamserver.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/web/")
public class WebController {
    private final UserRepository userRepository;

    @Autowired
    public WebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/auth/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping(path = "/auth/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}