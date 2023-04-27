package com.hitema.dao;

import com.hitema.DBConnection;
import com.hitema.entities.City;
import org.hibernate.Session;

import java.util.List;

public class CityDAOImpl implements DAO<City>{

    private final Session currentSession = DBConnection.getCurrentSession();
    @Override
    public List<City> findAll() {
        return currentSession.createQuery("FROM City", City.class).getResultList();
    }

    @Override
    public City find(Long id) {
        return currentSession.get(City.class, id);
    }

    @Override
    public void save(City object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.save(object);
        tx.commit();
    }

    @Override
    public void update(City object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.update(object);
        tx.commit();
    }

    @Override
    public void delete(City object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.delete(object);
        tx.commit();
    }
}
