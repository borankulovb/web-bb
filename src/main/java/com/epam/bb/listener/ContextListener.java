package com.epam.bb.listener;

import com.epam.bb.database.dao.DaoException;
import com.epam.bb.database.dao.DaoFactory;
import com.epam.bb.database.pool.ConnectionPool;
import com.epam.bb.database.pool.PoolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

//todo: add Hikari pool

public class ContextListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(ContextListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionPool pool;
        try {
            pool = new ConnectionPool();
            log.info("ConnectionPool has been created");

        } catch (PoolException e) {
            log.error("ConnectionPool couldn't be created");
            throw new RuntimeException();

        }

        DaoFactory.configure(pool, DaoFactory.DaoType.H2);
        log.info("Context Listener has closed connectionPool");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            DaoFactory.shutdown();
           log.info("Context Listener has closed connectionPool");
        } catch (SQLException e) {
            log.error("Context Listener couldn't close connectionPool");
            throw new DaoException();


        }
            /*TODO log timeout session or logout from application!bek*/

    }
}
