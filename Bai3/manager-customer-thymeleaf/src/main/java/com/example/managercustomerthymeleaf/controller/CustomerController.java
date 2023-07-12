package com.example.managercustomerthymeleaf.controller;

import com.example.managercustomerthymeleaf.model.Customer;
import com.example.managercustomerthymeleaf.service.ICustomerService;
import com.example.managercustomerthymeleaf.service.impl.CustomerServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping
    public ModelAndView home(){
        return new ModelAndView("/index","customers",customerService.findAll());
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/edit","customer",customerService.findById(id));
    }
    @PostMapping("/edit")
    public String  edit(Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        customerService.remove(id);
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id){
        return new ModelAndView("/view","customer",customerService.findById(id));
    }
}
