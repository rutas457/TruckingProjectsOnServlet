package com.training.ServletLogin.dao.impl;

import com.training.ServletLogin.dao.OrderDao;
import com.training.ServletLogin.dao.mapper.OrderMapper;
import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCOrderDao implements OrderDao {
    private Connection connection;


    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Order> findById(Long id) {
        final String query = "" +
                " select * from user_order " +
                "NATURAL JOIN route " +
                "NATURAL JOIN user"
                + " where user_order.id=?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();

            OrderMapper orderMapper = new OrderMapper();
            if (rs.next()) {
                Optional<Order> order = orderMapper.extractFromResultSet(rs);
                return order;
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Order> findAllByUser(User user) {
        List<Order> result = new ArrayList<>();
        final String query = "" +
                " select * from user_order " +
                "NATURAL JOIN route " +
                "NATURAL JOIN user " +
                "where user_id=?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setLong(1, user.getId());
            ResultSet rs = st.executeQuery();

            OrderMapper orderMapper = new OrderMapper();
            if (rs.next()) {
                result.add(orderMapper.extractFromResultSet(rs).orElseThrow(RuntimeException::new));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean create(Order entity) {
        final String query = "" +
                "INSERT INTO user_order(cargo_name, cargo_type, paid, price, shipping_end, " +
                "shipping_start, state, weight, route_id, user_id) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, entity.getCargoName());
            st.setString(2, entity.getCargoType().name());
            st.setBoolean(3, entity.getPaid());
            st.setLong(4, entity.getPrice());
            st.setObject(5, entity.getShippingEnd());
            st.setObject(6, entity.getShippingStart());
            st.setString(7, entity.getState().name());
            st.setInt(8, entity.getWeight());
            st.setLong(9, entity.getRoute().getId());
            st.setInt(10, entity.getUser().getId());
            return st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Order> findAll() {
        List<Order> result = new ArrayList<>();
        final String query = "" +
                " select * from user_order " +
                "NATURAL JOIN route " +
                "NATURAL JOIN user";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            ResultSet rs = st.executeQuery();

            OrderMapper orderMapper = new OrderMapper();
            if (rs.next()) {
                result.add(orderMapper.extractFromResultSet(rs).orElseThrow(RuntimeException::new));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
