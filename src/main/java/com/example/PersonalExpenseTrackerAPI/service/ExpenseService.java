package com.example.PersonalExpenseTrackerAPI.service;

import com.example.PersonalExpenseTrackerAPI.entity.Expense;
import com.example.PersonalExpenseTrackerAPI.repository.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
   public Expense  getById(Long id){
       return expenseRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(
                       HttpStatus.NOT_FOUND,
                       "Expense not found with id " + id
               ));

   }
   public Expense updateExpense(Long id , Expense expense){
       Expense existingExpense = getById(id);
       existingExpense.setTitle(expense.getTitle());
       existingExpense.setAmount(expense.getAmount());
       existingExpense.setCategory(expense.getCategory());
       existingExpense.setDate(expense.getDate());

       return expenseRepository.save(existingExpense);
   }
   public void deleteExpense(Long id){
       expenseRepository.delete(getById(id));
   }
   public List<Expense> filterExpense(String category){
       return expenseRepository.findByCategory(category);
   }
}
