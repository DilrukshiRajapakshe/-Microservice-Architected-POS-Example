package com.sliit.paf.payment.repository;

import com.sliit.paf.payment.entity.SuperEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class CrudRepositoryImpl<T extends SuperEntity, ID extends Serializable> implements CrudRepository<T, ID> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> entity;

    public CrudRepositoryImpl() {
        entity = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(T entity) {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(ID key) {
        getSession().delete(getSession().load(entity, key));
    }

    @Override
    public Optional<T> find(ID key) {
        return Optional.ofNullable(getSession().find(entity, key));
    }

    @Override
    public Optional<List<T>> findAll() {
        return Optional.ofNullable(getSession().createQuery("FROM " + entity.getName()).list());
    }
}
