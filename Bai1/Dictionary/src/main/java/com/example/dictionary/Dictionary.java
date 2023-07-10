package com.example.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Dictionary  {
    @Autowired
    Search search;
   @GetMapping("/dictionary")
   public String search(@RequestParam String eng, Model model){
       String result=search.search(eng);
       if(result==null){
           model.addAttribute("vn","Không có");
       }else{
       model.addAttribute("vn",result);
       }
       return "index";

   }


   @GetMapping("/home")
   public String home(){
       return "index";
   }
}