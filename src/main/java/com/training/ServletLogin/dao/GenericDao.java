package com.training.ServletLogin.dao;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    void create(T entity);

    List<T> findAll();

    void update(T entity);

    void delete(int id);

    void close();
}