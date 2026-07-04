package com.yatharth.ExpenseTracker.repository;

import com.yatharth.ExpenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByEmail(String email);
}