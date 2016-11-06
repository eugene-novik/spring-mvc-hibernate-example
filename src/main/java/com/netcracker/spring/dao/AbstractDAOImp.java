package com.netcracker.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class AbstractDAOImp<Key extends Serializable, E> implements IDAO<Key, E> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<E> clazz;

    protected AbstractDAOImp(Class<E> clazz) {
        this.clazz = clazz;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public E create(E entity) {
        Session session = getSession();
        session.persist(entity);
        session.flush();
        return entity;
    }

    @Override
    public E read(Key key) {
        return getSession().find(clazz, key);
    }

    @Override
    public void update(E entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(E entity) {
        getSession().delete(entity);
    }
}
