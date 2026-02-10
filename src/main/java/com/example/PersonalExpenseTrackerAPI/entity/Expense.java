package com.example.PersonalExpenseTrackerAPI.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private BigDecimal amount;
    private String category;
    private LocalDate date;

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
