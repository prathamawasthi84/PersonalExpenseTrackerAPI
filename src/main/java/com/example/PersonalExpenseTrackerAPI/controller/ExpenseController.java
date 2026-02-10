package com.example.PersonalExpenseTrackerAPI.controller;
import com.example.PersonalExpenseTrackerAPI.entity.Expense;
import com.example.PersonalExpenseTrackerAPI.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService){
     this.expenseService=expenseService;
    }
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }
    @GetMapping
    public List<Expense> getExpense() {
        return expenseService.getExpenses();
    }
    @GetMapping("/{id}")
    public Expense getById(@PathVariable Long id){
        return expenseService.getById(id);
    }
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id , @RequestBody Expense expense){
        return expenseService.updateExpense(id, expense);
    }
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
         expenseService.deleteExpense(id);

    }
}
