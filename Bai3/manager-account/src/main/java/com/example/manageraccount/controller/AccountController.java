package com.example.manageraccount.controller;

import com.example.manageraccount.model.Account;
import com.example.manageraccount.service.IAccountService;
import com.example.manageraccount.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @Autowired
    IAccountService accountService;
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("/index","accounts",accountService.findAllAccount());
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int id){
        return new ModelAndView("/edit","account",accountService.findById(id));
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        accountService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Account account){
        accountService.edit(account);
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/create","account",new Account());
    }

}
