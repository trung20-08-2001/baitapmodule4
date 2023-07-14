package com.login.service;

import com.login.dao.AccountDAO;
import com.login.dao.RoleDAO;
import com.login.enums.Role;
import com.login.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class AccountService {
    @Autowired
    AccountDAO accountDAO;

    @Autowired
    RoleDAO roleDAO;


    public Account findAccount(String username, String password){
        return accountDAO.findAccount(username, password);
    }

    public List<Account> getAllAccountUser(){
        return accountDAO.getAllAccountUser();
    }

    public String login(String username, String password) {
        Account account = accountDAO.findAccount(username, password);
        int idRole = account.getRole().getId();
        boolean status = account.isStatus();
        if (status) {
            if (idRole == Role.ADMIN.getValue()) {
                return "admin";
            } else {
                return "user";
            }
        } else {
            return "account-block";
        }
    }

    public void register(Account account, int idRole, MultipartFile fileImage) {
        com.login.model.Role role = roleDAO.findById(idRole);
        account.setRole(role);
        uploadImage(account, fileImage);
        accountDAO.save(account);
    }

    public void uploadImage(Account account, MultipartFile fileImage) {
        try {
            fileImage.transferTo(new File("C:\\Users\\trung\\Codegym\\Md4\\Bai5\\login\\src\\main\\webapp\\WEB-INF\\img\\" + fileImage.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        account.setAvatar("/img/" + fileImage.getOriginalFilename());
    }

    public boolean isAccountExist(String username) {
        Account account = accountDAO.findByUsername(username);
        if (account != null) {
            return true;
        } else {
            return false;
        }
    }

    public void block(int id){
        Account account=accountDAO.findById(id);
        account.setStatus(false);
        accountDAO.block(account);
    }

    public Account findById(int id){
        return accountDAO.findById(id);
    }

}
