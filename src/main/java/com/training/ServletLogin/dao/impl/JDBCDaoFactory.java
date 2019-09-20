package com.training.ServletLogin.dao.impl;

import com.training.ServletLogin.dao.DaoFactory;
import com.training.ServletLogin.dao.OrderDao;
import com.training.ServletLogin.dao.RouteDao;
import com.training.ServletLogin.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public OrderDao createOrderDao() {
        return new JDBCOrderDao(getConnection());
    }

    @Override
    public RouteDao createRouteDao() {
        return new JDBCRouteDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
