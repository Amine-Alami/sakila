package com.hitema.dao;

import java.util.List;

public interface DAO<T> {
    List<T> findAll();
    T find(int id);
    void save(T object);
    void update(T object);
    void delete(T object);
}