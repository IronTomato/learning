package com.sls.sample.dao;

public interface BaseDao<T,PK> {

	void add(T entity);
	
	void delete(T entity);
	
	void update(T entity);
	
	T findById(PK id);
}
