package com.hitema.dao;

import com.hitema.DBConnection;
import com.hitema.entities.Country;
import jakarta.transaction.Transactional;
import org.hibernate.Session;

import java.util.List;

@Transactional
public class CountryDAOImpl implements DAO<Country>{

    private final DBConnection dbConnection = new DBConnection();
    private final Session currentSession = dbConnection.getCurrentSession();
    @Override
    public List<Country> findAll() {
        return currentSession.createQuery("FROM Country", Country.class).getResultList();
    }

    @Override
    public Country find(int id) {
        return currentSession.get(Country.class, id);
    }

    @Override
    public void save(Country object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.persist(object);
        tx.commit();
    }

    @Override
    public void update(Country object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.update(object);
        tx.commit();
    }

    @Override
    public void delete(Country object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.delete(object);
        tx.commit();
    }
}
