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
import java.util.ResourceBundle;

public class JDBCOrderDao implements OrderDao {
    private Connection connection;
    private final ResourceBundle bundle = ResourceBundle.getBundle("queries");


    JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Order> findById(Long id) {
        try (PreparedStatement st = connection.prepareCall(bundle.getString("find.order.by.id"))) {
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            OrderMapper orderMapper = new OrderMapper();
            if (rs.next()) {
                return orderMapper.extractFromResultSet(rs);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findAllByUser(User user) {
        List<Order> result = new ArrayList<>();
        try (PreparedStatement st = connection.prepareCall(bundle.getString("find.all.orders.by.user.id"))) {
            st.setLong(1, user.getId());
            ResultSet rs = st.executeQuery();

            OrderMapper orderMapper = new OrderMapper();
            while (rs.next()) {
                result.add(orderMapper.extractFromResultSet(rs).orElseThrow(RuntimeException::new));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Order entity) {

        try (PreparedStatement st = connection.prepareCall(bundle.getString("insert.order"))) {
            System.out.println("Statement created!");
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
            st.executeUpdate();
            System.out.println("Statement executed!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> result = new ArrayList<>();
        final String query = bundle.getString("select.one.to.many.order.user");
        try (PreparedStatement st = connection.prepareCall(query)) {
            ResultSet rs = st.executeQuery();

            OrderMapper orderMapper = new OrderMapper();
            while (rs.next()) {
                result.add(orderMapper.extractFromResultSet(rs).orElseThrow(RuntimeException::new));
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStateById(Order order) {
        try (PreparedStatement st = connection.prepareCall(bundle.getString("update.state.by.id"))) {
            st.setString(1, order.getState().name());
            st.setLong(2, order.getId());
            st.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setPaidById(Order order) {
        try (PreparedStatement st = connection.prepareCall(bundle.getString("set.paid.by.id"))) {
            st.setLong(1, order.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
