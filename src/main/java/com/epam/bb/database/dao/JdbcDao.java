package com.epam.bb.database.dao;

import java.sql.Connection;

public abstract class JdbcDao {
    public Connection connection;

    public JdbcDao(Connection connection) {
    }
}

