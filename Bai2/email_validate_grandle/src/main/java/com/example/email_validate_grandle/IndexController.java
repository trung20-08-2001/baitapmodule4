package com.example.email_validate_grandle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    ValidateEmail validateEmail;
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }

    @PostMapping("/validate")
    public ModelAndView checkEmail(@RequestParam String email){
        if(validateEmail.validateEmail(email)){
            return new ModelAndView("/success","message",email);
        }else{
            return new ModelAndView("/index","message","Email is invalid");
        }
    }

}
