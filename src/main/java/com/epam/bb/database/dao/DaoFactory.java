package com.epam.bb.database.dao;

import com.epam.bb.database.Implementation.JdbcDaoFactory;
import com.epam.bb.database.pool.ConnectionPool;

import java.sql.SQLException;

public abstract class DaoFactory {
    protected static ConnectionPool pool;
    private static DaoType daoType;


    public static JdbcDaoFactory getDaoFactory() {

        switch (daoType) {
            case H2:
                return new JdbcDaoFactory(pool);
            default:
                return null;
        }
    }

    public static void configure(ConnectionPool pool, DaoType daoType) {
        DaoFactory.pool = pool;

        DaoFactory.daoType = daoType;
    }

    public static void shutdown() throws SQLException {
        pool.shutdown();
    }

    public abstract DaoManager getDaoManager() throws DaoException, SQLException, InterruptedException;

    public static enum DaoType {
        H2
    }

}

