package com.yatharth.ExpenseTracker.service;

import com.yatharth.ExpenseTracker.model.Budget;
import com.yatharth.ExpenseTracker.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository repository;

    public Budget saveBudget(Budget budget) {
        return repository.save(budget);
    }

    public Budget getBudget() {
        return repository.findAll()
                .stream()
                .findFirst()
                .orElse(null);
    }
}