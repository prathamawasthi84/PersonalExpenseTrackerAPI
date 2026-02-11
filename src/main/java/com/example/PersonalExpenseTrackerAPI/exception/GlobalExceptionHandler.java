package com.example.PersonalExpenseTrackerAPI.exception;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> exceptionHandling(MethodArgumentNotValidException ex){
        HashMap<String,String> map = new HashMap<>();
        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            map.put(field,message);
        }
        return map;
    }
}
