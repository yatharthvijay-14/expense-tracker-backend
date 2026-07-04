package com.yatharth.ExpenseTracker.service;

import com.yatharth.ExpenseTracker.model.Expense;
import com.yatharth.ExpenseTracker.repository.BudgetRepository;
import com.yatharth.ExpenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.stream.Collectors;
import com.yatharth.ExpenseTracker.dto.BudgetSummary;
import com.yatharth.ExpenseTracker.model.Budget;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;


    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }


    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }


    public Expense getExpenseById(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Expense updateExpense(Long id, Expense updatedExpense) {

        Expense existingExpense = repository.findById(id).orElse(null);

        if (existingExpense != null) {

            existingExpense.setTitle(updatedExpense.getTitle());
            existingExpense.setAmount(updatedExpense.getAmount());
            existingExpense.setCategory(updatedExpense.getCategory());

            return repository.save(existingExpense);
        }

        return null;
    }


    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }


    public List<Expense> getExpensesByCategory(String category) {
        return repository.findByCategory(category);
    }
    public double getTotalExpenses() {

        return repository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
    public Map<String, Double> getCategorySummary() {

        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)
                ));
    }
    public List<Expense> getExpensesByTitle(String title) {
        return repository.findByTitle(title);
    }
    @Autowired
    private BudgetRepository budgetRepository;
    public BudgetSummary getBudgetSummary() {

        Budget budget = budgetRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);

        double totalSpent = repository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        double budgetAmount =
                budget != null ? budget.getMonthlyBudget() : 0;

        double remaining =
                budgetAmount - totalSpent;

        return new BudgetSummary(
                budgetAmount,
                totalSpent,
                remaining
        );
    }
}