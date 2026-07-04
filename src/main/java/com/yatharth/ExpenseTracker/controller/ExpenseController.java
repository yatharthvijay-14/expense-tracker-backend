package com.yatharth.ExpenseTracker.controller;

import com.yatharth.ExpenseTracker.model.Expense;
import com.yatharth.ExpenseTracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.yatharth.ExpenseTracker.dto.BudgetSummary;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin
public class ExpenseController {

    @Autowired
    private ExpenseService service;


    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }


    @PostMapping
    public Expense addExpense(@Valid @RequestBody Expense expense) {
        return service.addExpense(expense);
    }
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return service.getExpenseById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
        return "Expense Deleted Successfully";
    }
    @PutMapping("/{id}")
    public Expense updateExpense(
            @PathVariable Long id,
            @RequestBody Expense expense) {

        return service.updateExpense(id, expense);
    }
    @GetMapping("/category/{category}")
    public List<Expense> getExpensesByCategory(
            @PathVariable String category) {

        return service.getExpensesByCategory(category);
    }
    @GetMapping("/total")
    public double getTotalExpenses() {
        return service.getTotalExpenses();
    }
    @GetMapping("/category-summary")
    public Map<String, Double> getCategorySummary() {
        return service.getCategorySummary();
    }
    @GetMapping("/title/{title}")
    public List<Expense> getExpensesByTitle(
            @PathVariable String title) {

        return service.getExpensesByTitle(title);
    }
    @GetMapping("/remaining-budget")
    public BudgetSummary getBudgetSummary() {
        return service.getBudgetSummary();
    }
}