package com.epam.bb.database.dao;

import com.epam.bb.database.Implementation.JdbcDaoUser;

import java.sql.Connection;

public interface DaoManager {
    Connection getConnection() throws DaoException;

    JdbcDaoUser getUserDao() throws DaoException;

    public void openTransaction() throws DaoException;

    public void closeTransaction() throws DaoException;

    public void commit() throws DaoException;

    public void rollBack() throws DaoException;

    public void close() throws DaoException;
}
