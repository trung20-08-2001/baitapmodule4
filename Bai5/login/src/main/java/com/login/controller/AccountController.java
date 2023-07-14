package com.login.controller;


import com.login.model.Account;
import com.login.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("account", new Account());
        return "/index";
    }


    @PostMapping("/register")
    public String register(Account account, @RequestParam int idRole, @RequestParam MultipartFile imageFile,Model model) {
        if (!accountService.isAccountExist(account.getUsername())) {
            accountService.register(account, idRole, imageFile);
//            model.addAttribute("message","Tạo tài khoản thành công");
        } else {
//            model.addAttribute("message","Tài khoản đã tồn tại");
        }
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,Model model) {
        model.addAttribute("account",accountService.findAccount(username,password));
        return "/" + accountService.login(username, password);
    }


    @GetMapping("/all_account")
    public String getAllAccountUser(int idAdmin,Model model){
        model.addAttribute("account",accountService.findById(idAdmin));
        model.addAttribute("accounts",accountService.getAllAccountUser());
        return "/admin";
    }

    @GetMapping("/block")
    public String block(@RequestParam int idUser,int idAdmin,Model model){
        accountService.block(idUser);
        model.addAttribute("account",accountService.findById(idAdmin));
        model.addAttribute("accounts",accountService.getAllAccountUser());
        return "/admin";
    }

}
