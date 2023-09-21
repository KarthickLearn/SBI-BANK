package com.sbi.userdetails.service.UserDetailsService.expectionHandling;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserExpectionHandle {




    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> InvalidDataGiven(ConstraintViolationException ex){

        HashMap<String, String> errmap = new HashMap<String,String>();
       ex.getConstraintViolations().forEach(err->{

           errmap.put(err.getPropertyPath().toString(),err.getMessage());

       });

      return errmap;


    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNameAlreadyTaken.class)
    public Map<String, String> getUsernametakex(UserNameAlreadyTaken unat){
        HashMap<String,String> errmap = new HashMap<String,String>();
        errmap.put("Username","The given Username already taken");

        return errmap;
    }



}
