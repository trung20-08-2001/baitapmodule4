package com.login.dao;

import com.login.enums.Role;
import com.login.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class AccountDAO {
    @Autowired
    EntityManager entityManager;
    @Autowired
    EntityTransaction entityTransaction;

    public Account findAccount(String username,String password){
        String queryStr="select a from Account a where a.username=:username and a.password=:password ";
        TypedQuery<Account> query=entityManager.createQuery(queryStr, Account.class).setParameter("username",username).setParameter("password",password);
        return query.getSingleResult();
    }


    public Account findById(int id){
        String queryStr="select a from Account a where a.id=:id ";
        TypedQuery<Account> query=entityManager.createQuery(queryStr, Account.class).setParameter("id",id);
        return query.getSingleResult();
    }

    public Account findByUsername(String username){
        String queryStr="select a from Account a where a.username= : username ";
        TypedQuery<Account> query=entityManager.createQuery(queryStr, Account.class).setParameter("username",username);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    public void block(Account account){
        entityTransaction.begin();
        entityManager.merge(account);
        entityTransaction.commit();
    }

    public void save(Account account){
        entityTransaction.begin();
        entityManager.persist(account);
        entityTransaction.commit();
    }

    public List<Account> getAllAccountUser(){
        String queryStr=" select a from Account a where a.role.id =: idRole";
        TypedQuery<Account> query=entityManager.createQuery(queryStr, Account.class).setParameter("idRole", Role.USER.getValue());
        return query.getResultList();
    }
}
