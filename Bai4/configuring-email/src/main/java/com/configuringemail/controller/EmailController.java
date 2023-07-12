package com.configuringemail.controller;

import com.configuringemail.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @GetMapping("/")
    public String index(Email email, Model model){
        model.addAttribute("email",new Email());
        return "/index";
    }

    @GetMapping("/setting")
    public String setting(){
        return "/setting";
    }

    @PostMapping("/setting")
    public String setting(Email email,Model model){
        model.addAttribute("email",email);
        return "/index";
    }
}
