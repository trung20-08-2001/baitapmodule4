package com.example.calculatorsimp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorSimpController {
    @RequestMapping("/")
    public ModelAndView home(){
        return new ModelAndView("/index");
    }

    @GetMapping("/calculator")
    public ModelAndView calculator(@RequestParam double fistNumber,double secondNumber,String operator ){
        if(operator.equals("+")){
            return new ModelAndView("/index","result",fistNumber+" + "+secondNumber+" = "+(fistNumber+secondNumber));
        }else if(operator.equals("-")){
            return new ModelAndView("/index","result",fistNumber+" - "+secondNumber+" = "+(fistNumber-secondNumber));
        }else if(operator.equals("*")){
            return new ModelAndView("/index","result",fistNumber+" * "+secondNumber+" = "+(fistNumber*secondNumber));
        }else{
            return new ModelAndView("/index","result",fistNumber+" / "+secondNumber+" = "+(fistNumber/secondNumber));
        }
    }
}
