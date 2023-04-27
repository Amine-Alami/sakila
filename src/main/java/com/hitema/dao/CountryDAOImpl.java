package com.hitema.dao;

import com.hitema.DBConnection;
import com.hitema.entities.Country;
import jakarta.transaction.Transactional;
import org.hibernate.Session;

import java.util.List;

@Transactional
public class CountryDAOImpl implements DAO<Country>{

    private final Session currentSession = DBConnection.getCurrentSession();
    @Override
    public List<Country> findAll() {
        return currentSession.createQuery("FROM Country", Country.class).getResultList();
    }

    @Override
    public Country find(Long id) {
        return currentSession.get(Country.class, id);
    }

    @Override
    public Country save(Country object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.persist(object);
        tx.commit();
        return object;
    }

    @Override
    public Country update(Country object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.update(object);
        tx.commit();
        return object;
    }

    @Override
    public void delete(Country object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.delete(object);
        tx.commit();
    }
}
