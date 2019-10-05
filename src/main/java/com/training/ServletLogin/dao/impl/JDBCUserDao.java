package com.training.ServletLogin.dao.impl;

import com.training.ServletLogin.dao.UserDao;
import com.training.ServletLogin.dao.mapper.UserMapper;
import com.training.ServletLogin.entity.User;

import java.sql.*;
import java.util.*;

public class JDBCUserDao implements UserDao {
    private Connection connection;
    private final ResourceBundle bundle = ResourceBundle.getBundle("queries");

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {
        try (PreparedStatement st = connection.prepareStatement(bundle.getString("insert.user"))) {
            st.setString(1, entity.getEmail());
            st.setString(2, entity.getName());
            st.setString(3, entity.getPassword());
            st.setString(4, entity.getSurname());
            st.setString(5, entity.getRole());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {

        try (PreparedStatement st = connection.prepareStatement(bundle.getString("select.user.by.email"))) {
            st.setString(1, email);
            ResultSet rs = st.executeQuery();

            UserMapper userMapper = new UserMapper();
            if (rs.next()) {
                return userMapper.extractFromResultSet(rs);
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public List<User> findAll() {
        Map<Long, User> users = new HashMap<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(bundle.getString("select.all.from.user"));
            UserMapper userMapper = new UserMapper();

            while (rs.next()) {
                User user = userMapper
                        .extractFromResultSet(rs).orElseThrow(RuntimeException::new);
                user = userMapper
                        .makeUnique(users, user);
            }
            return new ArrayList<>(users.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}