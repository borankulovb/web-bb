package com.epam.bb.database.dao;

import com.epam.bb.entity.User;

public interface UserDao extends Dao<User> {

    User findByLastName(String lastName) throws DaoException;

    User findByEmail(String email) throws DaoException;

    User findByUsername(String username) throws DaoException;

}
