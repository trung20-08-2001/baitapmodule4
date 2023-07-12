package com.healthdeclaration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthDeclaration {
    @GetMapping("/")
    public String index(){
        return "/index";
    }

    @GetMapping("/declaration")
    public String notification(){
        return "/notifications";
    }
}
