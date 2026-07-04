package com.yatharth.ExpenseTracker.repository;

import com.yatharth.ExpenseTracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

}