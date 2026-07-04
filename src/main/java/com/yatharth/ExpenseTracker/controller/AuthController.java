package com.yatharth.ExpenseTracker.controller;

import com.yatharth.ExpenseTracker.model.User;
import com.yatharth.ExpenseTracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(
            @RequestBody User user
    ) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody User user
    ) {

        User loggedInUser =
                userService.login(
                        user.getEmail(),
                        user.getPassword()
                );

        if (loggedInUser != null) {
            return "Login Successful";
        }

        return "Invalid Credentials";
    }
}