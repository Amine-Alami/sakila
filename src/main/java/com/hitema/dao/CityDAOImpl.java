package com.hitema.dao;

import com.hitema.DBConnection;
import com.hitema.entities.City;
import com.hitema.entities.Country;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public City save(City object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.save(object);
        tx.commit();
        return object;
    }

    @Override
    public City update(City object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.update(object);
        tx.commit();
        return object;
    }

    @Override
    public void delete(City object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.delete(object);
        tx.commit();
    }

    public List<City> getAllByCountry(String country) {
        return currentSession.createQuery(
                "SELECT ci FROM City ci " +
                    "join Country co on ci.country.id = co.id " +
                    "where co.name = :country"
                , City.class)
                .setParameter("country",country)
                .getResultList();
    }
}
