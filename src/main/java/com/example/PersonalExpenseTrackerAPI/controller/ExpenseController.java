package com.example.PersonalExpenseTrackerAPI.controller;
import com.example.PersonalExpenseTrackerAPI.entity.Expense;
import com.example.PersonalExpenseTrackerAPI.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService){
     this.expenseService=expenseService;
    }
    @PostMapping("/expenses")
    public Expense addExpense(@RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }
    @GetMapping("/expenses")
    public List<Expense> getExpense(){
        return expenseService.getExpenses();
    }
}
