package com.epam.bb.database.Implementation;

import com.epam.bb.database.dao.DaoException;
import com.epam.bb.database.dao.DaoUtil;
import com.epam.bb.database.dao.JdbcDao;
import com.epam.bb.database.dao.UserDao;
import com.epam.bb.entity.Address;
import com.epam.bb.entity.Role;
import com.epam.bb.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcDaoUser extends JdbcDao implements UserDao {

    private static final String SQL_FIND_BY_ID = "SELECT id, username, password, phone_number, firstname, lastname, email, role, birthdate, address FROM User WHERE id = ?";
    private static final String SQL_FIND_BY_USERNAME = "SELECT id, username, password, phone_number, firstname, lastname, email, role, birthdate, address FROM User WHERE username = ?";
    private static final String SQL_FIND_BY_FIRSTNAME = "SELECT id, username, password, phone_number, firstname, lastname, email, role, birthdate, address FROM User WHERE firstname = ?";
    private static final String SQL_FIND_BY_LASTNAME = "SELECT id, username, password, phone_number, firstname, lastname, email, role, birthdate, address FROM User WHERE lastname = ?";
    private static final String SQL_FIND_BY_EMAIL = "SELECT id, username, password, phone_number, firstname, lastname, email, role, birthdate, address FROM User WHERE email = ?";

    public JdbcDaoUser(Connection connection) {
        super(connection);
    }

    @Override
    public User findByFirstName(String firstName) throws DaoException {
        return find(SQL_FIND_BY_FIRSTNAME, firstName);
    }

    @Override
    public User findByLastName(String lastName) throws DaoException {
        return find(SQL_FIND_BY_LASTNAME, lastName);
    }

    @Override
    public User findByEmail(String email) throws DaoException {
        return find(SQL_FIND_BY_EMAIL, email);
    }

    @Override
    public User findByUsername(String username) throws DaoException {
        return find(SQL_FIND_BY_USERNAME, username);
    }

    public void insert(User user) throws DaoException {

    }

    @Override
    public User findById(int id) throws DaoException {
        return find(SQL_FIND_BY_ID, id);
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

    private static User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setPhoneNumber(resultSet.getString("phone_number"));
        user.setFirstname(resultSet.getString("firstname"));
        user.setLastname(resultSet.getString("lastname"));
        user.setEmail(resultSet.getString("email"));
        user.setRole((Role) resultSet.getObject("role"));
        user.setBirthDate(resultSet.getDate("birthdate"));
        user.setAddress((Address) resultSet.getObject("address"));
        return user;
    }

    private User find(String sql, Object... values) throws DaoException {
        User user = null;

        try (
                PreparedStatement statement = DaoUtil.prepareStatement(this.connection, sql, false, values);
                ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                user = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }
}
