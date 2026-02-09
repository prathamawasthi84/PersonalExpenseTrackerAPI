package com.example.PersonalExpenseTrackerAPI.service;

import com.example.PersonalExpenseTrackerAPI.entity.Expense;
import com.example.PersonalExpenseTrackerAPI.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ExpenseService {
    private final ExpenseRepository expenseRepository;

   public ExpenseService(ExpenseRepository expenseRepository){
       this.expenseRepository=expenseRepository;
   }
   public Expense addExpense(Expense expense){
       return expenseRepository.save(expense);
   }
   public List<Expense> getExpenses(){
       return expenseRepository.findAll();
   }
}
