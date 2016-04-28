package com.sls.sample.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sls.sample.dao.BaseDao;

public abstract class BaseDaoImpl<T, PK> extends SqlSessionDaoSupport implements BaseDao<T, PK> {

	protected abstract String getNamespace();

	protected <E extends Enum<E>> String getFullMethodName(E methodName) {
		return getNamespace() + "." + methodName.name();
	}

	public void insert(T entity) {
		getSqlSession().insert(getFullMethodName(MethodName.insert), entity);
	}

	public void delete(T entity) {
		getSqlSession().delete(getFullMethodName(MethodName.delete), entity);
	}

	public void update(T entity) {
		getSqlSession().update(getFullMethodName(MethodName.update), entity);
	}

	public T findById(PK id) {
		return getSqlSession().selectOne(getFullMethodName(MethodName.findById), id);
	}

	private static enum MethodName {
		add, delete, update, insert, findById;
	}
}
