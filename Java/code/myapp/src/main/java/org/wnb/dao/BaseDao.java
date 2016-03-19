package org.wnb.dao;

import java.util.List;

import org.wnb.entity.City;

public interface BaseDao<T, PK> {

    T findById(PK id);

    List<T> findAll();

    void add(T entity);

    void update(T entity);

    void delete(T entity);

}
