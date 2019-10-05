package com.training.ServletLogin.dao.impl;

import com.training.ServletLogin.dao.OrderDao;
import com.training.ServletLogin.dao.mapper.OrderMapper;
import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class JDBCOrderDao implements OrderDao {
    private static final Logger logger = LogManager.getLogger(JDBCOrderDao.class);
    private Connection connection;
    private final ResourceBundle bundle = ResourceBundle.getBundle("queries");


    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    //TODO DB properties all queries
    @Override
    public Optional<Order> findById(Long id) {
        final String query = " select * from user_order " +
                "INNER JOIN route " +
                "ON user_order.route_id = route.id " +
                "INNER JOIN user " +
                "ON user_order.user_id = user.id " +
                "where user_order.id = ?";
        try (PreparedStatement st = connection.prepareCall(query)) {
            logger.info("Select statement prepared");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            logger.info("Query executed");
            OrderMapper orderMapper = new OrderMapper();
            if (rs.next()) {
                logger.info("Select ended");
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
        final String query = "" +
                " select * from user_order " +
                "INNER JOIN route " +
                "ON user_order.route_id = route.id " +
                "INNER JOIN user " +
                "ON user_order.user_id = user.id " +
                "where user_order.user_id = ?";
        try (PreparedStatement st = connection.prepareCall(query)) {
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
        final String query = "" +
                "INSERT INTO user_order(cargo_name, cargo_type, paid, price, shipping_end, " +
                "shipping_start, state, weight, route_id, user_id) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement st = connection.prepareCall(query)) {
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
        final String query = "UPDATE" +
                " user_order SET state =? where id=?";
        try (PreparedStatement st = connection.prepareCall(query)) {
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
        final String query = "UPDATE" +
                " user_order SET paid = true where id=?";
        try (PreparedStatement st = connection.prepareCall(query)) {
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
