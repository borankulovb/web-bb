package com.epam.bb.database.dao;
//TODO: generic Execute
public interface DaoCommand {
    public Object execute(DaoManager daoManager) throws Exception;
}
