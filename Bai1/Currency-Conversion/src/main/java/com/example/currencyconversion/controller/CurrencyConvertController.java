package com.example.currencyconversion.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConvertController {

    @GetMapping("/convert")
    public String convert(@RequestParam double usd,double rate, Model model){
        double vnd=usd*rate;
        model.addAttribute("many",vnd);
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "index";
    }
}
