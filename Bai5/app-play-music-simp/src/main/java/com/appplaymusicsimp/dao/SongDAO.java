package com.appplaymusicsimp.dao;

import com.appplaymusicsimp.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Component
public class SongDAO {
    @Autowired
    EntityManager entityManager;

    @Autowired
    EntityTransaction entityTransaction;
    public List<Song> getAll(){
        String queryStr = "SELECT s FROM Song s ";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        return query.getResultList();
    }

    public void save(Song song){
        entityTransaction.begin();
        entityManager.persist(song);
        entityTransaction.commit();
    }

    public Song findById(int id){
        String queryStr=" select s from Song s where s.id= : id ";
        TypedQuery<Song> query=entityManager.createQuery(queryStr, Song.class).setParameter("id",id);
        return query.getSingleResult();
    }

    public void delete(int id){
        entityTransaction.begin();
        entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    public void edit(Song song){
        entityTransaction.begin();
        entityManager.merge(song);
        entityTransaction.commit();
    }
}
