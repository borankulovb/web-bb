package com.epam.bb.database.Implementation;

import com.epam.bb.database.dao.DaoException;
import com.epam.bb.database.dao.JdbcDao;
import com.epam.bb.database.dao.UserDao;
import com.epam.bb.entity.User;

import java.sql.Connection;
import java.util.List;

public class JdbcDaoUser extends JdbcDao implements UserDao {

    public JdbcDaoUser(Connection connection) {
        super(connection);
    }

    @Override
    public User findByLastName(String lastName) throws DaoException {
        return null;
    }

    @Override
    public User findByEmail(String email) throws DaoException {
        return null;
    }

    @Override
    public User findByUsername(String username) throws DaoException {
        return null;
    }

    @Override
    public void insert(User entity) throws DaoException {

    }

    @Override
    public User findById(int id) throws DaoException {
        return null;
    }

    @Override
    public void update(User entityToUpdate) throws DaoException {

    }

    @Override
    public void deleteById(User entityToDelete) throws DaoException {

    }

    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }
}
