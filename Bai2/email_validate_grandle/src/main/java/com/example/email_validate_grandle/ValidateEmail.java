package com.example.email_validate_grandle;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
@Service
public class ValidateEmail {
    final String EMAIL_REGEX= "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public boolean validateEmail(String email){
        return Pattern.matches(EMAIL_REGEX,email);
    }
}
