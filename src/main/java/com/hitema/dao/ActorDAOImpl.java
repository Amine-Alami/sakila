package com.hitema.dao;

import com.hitema.DBConnection;
import com.hitema.entities.Actor;
import org.hibernate.Session;

import java.util.List;

public class ActorDAOImpl implements DAO<Actor>{
    private final Session currentSession = DBConnection.getCurrentSession();
    @Override
    public List<Actor> findAll() {
        return currentSession.createQuery("FROM Actor", Actor.class).getResultList();
    }

    @Override
    public Actor find(Long id) {
        return currentSession.get(Actor.class, id);
    }

    @Override
    public Actor save(Actor object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.save(object);
        tx.commit();
        return object;
    }

    @Override
    public Actor update(Actor object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.update(object);
        tx.commit();
        return object;
    }

    @Override
    public void delete(Actor object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.delete(object);
        tx.commit();
    }
}
