package com.example.PersonalExpenseTrackerAPI.controller;

import com.example.PersonalExpenseTrackerAPI.dto.CreateExpenseRequest;
import com.example.PersonalExpenseTrackerAPI.entity.User;
import com.example.PersonalExpenseTrackerAPI.service.ExpenseService;
import com.example.PersonalExpenseTrackerAPI.service.UserService;
import com.example.PersonalExpenseTrackerAPI.dto.ExpenseResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ExpenseService expenseService;
    public UserController(UserService userService,ExpenseService expenseService){
        this.userService=userService;
        this.expenseService=expenseService;
    }
    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
    @PostMapping("/{userid}/expenses")
    public ExpenseResponse createExpenseForUser(@PathVariable Long userid , @Valid @RequestBody CreateExpenseRequest request){
        return expenseService.createExpense(userid, request);
    }
    @GetMapping("/{userid}/expenses")
    public List<ExpenseResponse> getExpenseForUser(@PathVariable Long userid){
        return expenseService.findAllUserExpenses(userid);
    }
}
