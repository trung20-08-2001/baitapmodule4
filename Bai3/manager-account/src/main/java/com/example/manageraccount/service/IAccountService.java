package com.example.manageraccount.service;

import com.example.manageraccount.model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAllAccount();
    void delete(int id);
    void save(Account account);
    void edit(Account account);
    Account findById(int id);

}
