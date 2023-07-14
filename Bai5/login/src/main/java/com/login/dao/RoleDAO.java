package com.login.dao;

import com.login.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

@Component
public class RoleDAO {
    @Autowired
    EntityManager entityManager;
    @Autowired
    EntityTransaction entityTransaction;

    public Role findById(int id){
        String queryStr="select r from Role r where r.id= :id ";
        TypedQuery<Role> query=entityManager.createQuery(queryStr, Role.class).setParameter("id",id);
        return query.getSingleResult();
    }
}
