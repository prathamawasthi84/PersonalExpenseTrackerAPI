package com.example.PersonalExpenseTrackerAPI.service;

import com.example.PersonalExpenseTrackerAPI.dto.CreateExpenseRequest;
import com.example.PersonalExpenseTrackerAPI.dto.ExpenseResponse;
import com.example.PersonalExpenseTrackerAPI.entity.Expense;
import com.example.PersonalExpenseTrackerAPI.entity.User;
import com.example.PersonalExpenseTrackerAPI.mapper.ExpenseMapper;
import com.example.PersonalExpenseTrackerAPI.repository.ExpenseRepository;
import com.example.PersonalExpenseTrackerAPI.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service

public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final ExpenseMapper expenseMapper;

   public ExpenseService(ExpenseRepository expenseRepository , UserRepository userRepository,ExpenseMapper expenseMapper){
       this.expenseRepository=expenseRepository;
       this.userRepository=userRepository;
       this.expenseMapper=expenseMapper;
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
   public ExpenseResponse createExpense(Long userid, CreateExpenseRequest request){
       User user = userRepository.findById(userid).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found" + userid));
       Expense expense = expenseMapper.toEntity(request);
       expense.setUser(user);
       Expense savedExpense = expenseRepository.save(expense);
       return expenseMapper.toResponse(savedExpense);
   }
   public List<ExpenseResponse> findAllUserExpenses(Long userid){
        userRepository.findById(userid).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found" + userid));
        List<Expense> expenses = expenseRepository.findByUserId(userid);
        List<ExpenseResponse> responses = new ArrayList<>();
        for(Expense expense : expenses){
            ExpenseResponse response = expenseMapper.toResponse(expense);
            responses.add(response);
        }
        return responses;
   }
}
