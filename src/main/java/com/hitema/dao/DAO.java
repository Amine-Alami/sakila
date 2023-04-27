package com.hitema.dao;

import java.util.List;

public interface DAO<T> {
    List<T> findAll();
    T find(Long id);
    T save(T object);
    T update(T object);
    void delete(T object);
}
