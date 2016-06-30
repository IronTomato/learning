package com.wnb.dao;

import java.util.List;

public interface BaseDao<T, PK> {

    T findById(PK id);

    List<T> findAll();

    void add(T entity);

    void update(T entity);

    void delete(T entity);

}
