package com.example.PersonalExpenseTrackerAPI.mapper;

import com.example.PersonalExpenseTrackerAPI.dto.CreateExpenseRequest;
import com.example.PersonalExpenseTrackerAPI.dto.ExpenseResponse;
import com.example.PersonalExpenseTrackerAPI.entity.Expense;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {
    public Expense toEntity(CreateExpenseRequest createExpenseRequest){
     Expense expense = new Expense();
     expense.setTitle(createExpenseRequest.getTitle());
     expense.setAmount(createExpenseRequest.getAmount());
     expense.setCategory(createExpenseRequest.getCategory());
     expense.setDate(createExpenseRequest.getDate());
     return expense;
    }
    public ExpenseResponse toResponse(Expense expense){
        ExpenseResponse expenseResponse = new ExpenseResponse();
        expenseResponse.setId(expense.getId());
        expenseResponse.setTitle(expense.getTitle());
        expenseResponse.setAmount(expense.getAmount());
        expenseResponse.setCategory(expense.getCategory());
        expenseResponse.setDate(expense.getDate());
        return  expenseResponse;
    }
}
