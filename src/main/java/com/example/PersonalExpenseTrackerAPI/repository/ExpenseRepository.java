package com.example.PersonalExpenseTrackerAPI.repository;


import com.example.PersonalExpenseTrackerAPI.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
