package com.sbi.userdetails.service.UserDetailsService.expectionHandling;

public class UserNameAlreadyTaken extends RuntimeException {
    public UserNameAlreadyTaken(String message) {
        super(message);
    }
}
