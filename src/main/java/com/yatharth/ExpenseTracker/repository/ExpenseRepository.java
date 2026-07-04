package com.yatharth.ExpenseTracker.repository;

import com.yatharth.ExpenseTracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByCategory(String category);
    List<Expense> findByTitle(String title);

}