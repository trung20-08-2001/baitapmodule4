package com.login.controller;

import com.login.model.Account;
import com.login.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class AccountController {
    @Autowired
    Login login;
    @RequestMapping("/")
    public String index( Model model){
        model.addAttribute("account",new Account());
        return "/index";
    }

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public ModelAndView login(@ModelAttribute Account account,Model model){
        if(login.findAccount(account.getAccount(), account.getPassword())!=null){
            return new ModelAndView("/show","account",login.findAccount(account.getAccount(), account.getPassword()));
        }else{
            return new ModelAndView("/error","notfound","Account not found");
        }
    }
}
