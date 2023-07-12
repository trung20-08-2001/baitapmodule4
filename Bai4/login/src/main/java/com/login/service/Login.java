package com.login.service;

import com.login.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
@Component
public class Login {
   static List<Account> accountList=new ArrayList<>();
    static {
        accountList.add(new Account("account1","123456789","name1","email1",15));
        accountList.add(new Account("account2","123456789","name2","email2",15));
        accountList.add(new Account("account3","123456789","name3","email3",15));
        accountList.add(new Account("account4","123456789","name4","email4",15));
        accountList.add(new Account("account5","123456789","name5","email5",15));
    }

    public Account findAccount(String account,String password){
        for(Account acc:accountList){
            if(acc.getAccount().equals(account)&&acc.getPassword().equals(password)){
                return acc;
            }
        }
        return null;
    }
}
