package com.example.sandwichcondiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichCondimentsController {
    @RequestMapping("/")
    public ModelAndView home(){
        return new ModelAndView("/index");
    }

    @GetMapping("/save")
    public ModelAndView save(String[] condiment){
        return new ModelAndView("/index","condiments",condiment);
    }
}
