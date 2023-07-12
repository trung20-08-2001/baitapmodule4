package com.example.manageraccount.service.impl;

import com.example.manageraccount.model.Account;
import com.example.manageraccount.service.IAccountService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
@Component
public class AccountServiceImpl implements IAccountService {
   public static TreeMap<Integer,Account> treeMap =new TreeMap<>();
    static {
        treeMap.put(1,new Account("2023-07-11","name1","123456789",""));
        treeMap.put(2,new Account("2023-07-11","name2","123456789",""));
        treeMap.put(3,new Account("2023-07-11","name3","123456789",""));
        treeMap.put(4,new Account("2023-07-11","name4","123456789",""));
        treeMap.put(5,new Account("2023-07-11","name5","123456789",""));
    }

    @Override
    public List<Account> findAllAccount() {
        return new ArrayList<>(treeMap.values());
    }

    @Override
    public void delete(int id) {
        treeMap.remove(id);
    }

    @Override
    public void save(Account account) {
        treeMap.put(account.getId(),account);
    }

    @Override
    public void edit( Account account) {
        treeMap.put(account.getId(),account);
    }

    @Override
    public Account findById(int id) {
        return treeMap.get(id);
    }
}
