package com.epam.bb.database.dao;

public interface DaoManager {

    UserDao getUserDao() throws DaoException;

    public Object executeAndClose(DaoCommand command) throws Exception;

    public Object transaction(DaoCommand command) throws Exception;

    public Object transactionAndClose(DaoCommand command) throws Exception;

}
