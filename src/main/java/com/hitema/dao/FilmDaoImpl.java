package com.hitema.dao;

import com.hitema.DBConnection;
import com.hitema.entities.City;
import com.hitema.entities.Country;
import com.hitema.entities.Film;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FilmDaoImpl implements DAO<Film>{

    private final Session currentSession = DBConnection.getCurrentSession();
    @Override
    public List<Film> findAll() {
        return currentSession.createQuery("FROM Film", Film.class).getResultList();
    }

    @Override
    public Film find(Long id) {
        return currentSession.get(Film.class, id);
    }

    @Override
    public Film save(Film object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.persist(object);
        tx.commit();
        return object;
    }

    @Override
    public Film update(Film object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.update(object);
        tx.commit();
        return object;
    }

    @Override
    public void delete(Film object) {
        var tx = currentSession.getTransaction();
        tx.begin();
        currentSession.delete(object);
        tx.commit();
    }

    public List<Film> getAllByActor(String firstName, String lastName) {
        return currentSession.createQuery(
                        "SELECT f FROM Film f join Actor a " +
                            "where a.firstName = :firstName and a.lastName = :lastName"
                        , Film.class)
                .setParameter("firstName",firstName)
                .setParameter("lastName",lastName)
                .getResultList();
    }
}
