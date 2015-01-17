package com.epam.bb.database.Implementation;

import com.epam.bb.database.dao.DaoException;
import com.epam.bb.database.dao.DaoManager;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDaoManager implements DaoManager {
    private Connection connection;

    public JdbcDaoManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    public JdbcDaoUser getUserDao() {
        return new JdbcDaoUser(connection);
    }

    @Override
    public void openTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void closeTransaction() throws DaoException {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void commit() throws DaoException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void rollBack() throws DaoException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void close() throws DaoException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}

