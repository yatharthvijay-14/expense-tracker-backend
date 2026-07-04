package com.yatharth.ExpenseTracker.service;

import com.yatharth.ExpenseTracker.model.User;
import com.yatharth.ExpenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {

        User existingUser =
                userRepository.findByEmail(
                        user.getEmail()
                );

        if (existingUser != null) {
            throw new RuntimeException(
                    "Email already exists"
            );
        }

        return userRepository.save(user);
    }

    public User login(
            String email,
            String password
    ) {

        User user =
                userRepository.findByEmail(email);

        if (
                user != null &&
                        user.getPassword()
                                .equals(password)
        ) {
            return user;
        }

        return null;
    }
}