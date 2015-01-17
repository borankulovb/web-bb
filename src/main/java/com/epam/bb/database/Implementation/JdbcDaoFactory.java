package com.epam.bb.database.Implementation;

import com.epam.bb.database.dao.DaoException;
import com.epam.bb.database.dao.DaoFactory;
import com.epam.bb.database.dao.DaoManager;
import com.epam.bb.database.pool.ConnectionPool;

import java.sql.Connection;

public class JdbcDaoFactory extends DaoFactory {

    public JdbcDaoFactory(ConnectionPool pool) {
        DaoFactory.pool = pool;
    }

    public DaoManager getDaoManager() throws DaoException {
        Connection connection;

        connection = pool.takeConnection();

        return new JdbcDaoManager(connection);
    }

}
