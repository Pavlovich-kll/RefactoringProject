package com.user.interview.refactoring.controller;

import com.user.interview.refactoring.domain.User;
import com.user.interview.refactoring.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/users")
    public User saveUser(User user) {
        userRepository.save(user);
        return userRepository.findById(user.getId());
    }

    @PostMapping("/users/{id}")
    public User updateUser(User user) {
        userRepository.update(user);
        return user;
    }

    @GetMapping("/users/{id}/delete")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }
}
