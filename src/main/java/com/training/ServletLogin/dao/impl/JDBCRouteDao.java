package com.training.ServletLogin.dao.impl;

import com.training.ServletLogin.dao.RouteDao;
import com.training.ServletLogin.dao.mapper.RouteMapper;
import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCRouteDao implements RouteDao {
    private Connection connection;

    JDBCRouteDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Optional<Route> findByStartCityAndEndCity(String startCity, String endCity) {
        final String query = "" +
                " select * from route where start_city=? and end_city=?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, startCity);
            st.setString(2, endCity);
            ResultSet rs = st.executeQuery();

            RouteMapper routeMapper = new RouteMapper();
            if (rs.next()) {
                return routeMapper.extractFromResultSet(rs);
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void create(Order entity) {
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void update(Order entity) {

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
