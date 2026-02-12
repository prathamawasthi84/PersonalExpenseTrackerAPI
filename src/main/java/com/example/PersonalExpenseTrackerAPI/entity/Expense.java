package com.example.PersonalExpenseTrackerAPI.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message="Title is required")
    private String title;
    @Positive(message="Amount cannot be negative")
    private BigDecimal amount;
    private String category;
    @NotNull(message = "Date cannot be empty")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    public Expense(){

    }
    public Expense(Long id,String title,BigDecimal amount,String category,LocalDate date){
        this.id=id;
        this.amount=amount;
        this.title=title;
        this.category=category;
        this.date =date;
    }
    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id =id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public BigDecimal getAmount(){
        return amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount=amount;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
}
