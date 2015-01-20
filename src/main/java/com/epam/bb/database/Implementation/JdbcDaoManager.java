package com.epam.bb.database.Implementation;

import com.epam.bb.database.dao.DaoCommand;
import com.epam.bb.database.dao.DaoManager;

import java.sql.Connection;

public class JdbcDaoManager implements DaoManager {
    protected JdbcDaoUser JdbcDaoUser = null;
    private Connection connection;

    public JdbcDaoManager(Connection connection) {
        this.connection = connection;
    }

    public JdbcDaoUser getUserDao() {
        if (this.JdbcDaoUser == null) {
            this.JdbcDaoUser = new JdbcDaoUser(this.connection);
        }
        return this.JdbcDaoUser;
    }

    @Override
    public Object executeAndClose(DaoCommand command) throws Exception {
        try {
            return command.execute(this);
        } finally {
            this.connection.close();
        }
    }

    @Override
    public Object transaction(DaoCommand command) throws Exception {
        try {
            this.connection.setAutoCommit(false);
            Object returnValue = command.execute(this);
            this.connection.commit();
            return returnValue;
        } catch (Exception e) {
            this.connection.rollback();
            throw e; //or wrap it before rethrowing it
        } finally {
            this.connection.setAutoCommit(true);
        }
    }

    @Override
    public Object transactionAndClose(final DaoCommand command) throws Exception {
        executeAndClose(new DaoCommand() {
            public Object execute(DaoManager manager) throws Exception {
                return manager.transaction(command);
            }
        });
        return null;
    }

}

