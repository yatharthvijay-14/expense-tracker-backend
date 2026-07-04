package com.yatharth.ExpenseTracker.controller;

import com.yatharth.ExpenseTracker.model.Budget;
import com.yatharth.ExpenseTracker.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budget")
@CrossOrigin
public class BudgetController {

    @Autowired
    private BudgetService service;

    @PostMapping
    public Budget saveBudget(@RequestBody Budget budget) {
        return service.saveBudget(budget);
    }

    @GetMapping
    public Budget getBudget() {
        return service.getBudget();
    }
}