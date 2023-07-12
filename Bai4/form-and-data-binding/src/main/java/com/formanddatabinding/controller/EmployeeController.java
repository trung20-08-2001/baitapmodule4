package com.formanddatabinding.controller;

import com.formanddatabinding.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("/index","employee",new Employee());
    }

    @RequestMapping(value = "/show",method = RequestMethod.POST)
    public ModelAndView show(@ModelAttribute Employee employee){
        return new ModelAndView("/show","employee",employee);
    }
}
