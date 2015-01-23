package com.epam.bb.database.dao;

import com.epam.bb.database.Implementation.JdbcDaoFactory;
import com.epam.bb.database.pool.ConnectionPool;

import java.sql.SQLException;

public class DaoFactory {
    protected static ConnectionPool pool;
    private static DaoType daoType;

    public static ConnectionPool getPool() {
        return pool;
    }

    public static JdbcDaoFactory getDaoFactory() {


                return new JdbcDaoFactory(pool);


    }

    public static void configure(ConnectionPool pool, DaoType daoType)  {

        DaoFactory.pool = pool;

        DaoFactory.daoType = daoType;
    }

    public static void shutdown() throws SQLException {
        pool.shutdown();
    }



    public static enum DaoType {
        H2
    }

}

