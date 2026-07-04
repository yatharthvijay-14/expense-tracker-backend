package com.yatharth.ExpenseTracker.dto;

public class BudgetSummary {

    private double budget;
    private double spent;
    private double remaining;

    public BudgetSummary(double budget, double spent, double remaining) {
        this.budget = budget;
        this.spent = spent;
        this.remaining = remaining;
    }

    public double getBudget() {
        return budget;
    }

    public double getSpent() {
        return spent;
    }

    public double getRemaining() {
        return remaining;
    }
}