package org.wnb.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public abstract class BaseDaoImpl<T, PK> {

    protected SqlSession getSession() {
        return MyBatisUtil.getSqlSessionFactory().openSession();
    }

    protected abstract String namespace();

    public T findById(PK id) {
        return getSession().selectOne(MethodName.findById.fullName(namespace()), id);
    }

    public List<T> findAll() {
        return getSession().selectList(MethodName.findAll.fullName(namespace()));
    }

    public void add(T entity) {
        getSession().insert(MethodName.add.fullName(namespace()), entity);
    }

    public void update(T entity) {
        getSession().update(MethodName.update.fullName(namespace()), entity);
    }

    public void delete(T entity) {
        getSession().delete(MethodName.delete.fullName(namespace()), entity);
    }

    private static enum MethodName {
        findById, findAll, add, update, delete;

        public String fullName(String namespace) {
            return namespace + "." + this.name();
        }
    }
}
