package com.epam.bb.database.dao;

import com.epam.bb.entity.BaseEntity;

import java.util.List;

public interface Dao<T extends BaseEntity> {

    void insert(T entity) throws DaoException;

    T findById(int id) throws DaoException;

    void update(T entityToUpdate) throws DaoException;

    void deleteById(T entityToDelete) throws DaoException;

    List<T> findAll() throws DaoException;

}