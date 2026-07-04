package com.yatharth.ExpenseTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monthlyBudget;

    public Budget() {
    }

    public Budget(Long id, double monthlyBudget) {
        this.id = id;
        this.monthlyBudget = monthlyBudget;
    }

    public Long getId() {
        return id;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public void setId(Long id) {
        this.id = id;
    }
}