package com.training.ServletLogin.dao.mapper;

import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.Route;
import com.training.ServletLogin.entity.User;
import com.training.ServletLogin.entity.enumerated.CargoType;
import com.training.ServletLogin.entity.enumerated.OrderStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class OrderMapper implements ObjectMapper<Order> {


    @Override
    public Optional<Order> extractFromResultSet(ResultSet rs) throws SQLException {
        Order order = Order.builder()
                .id(rs.getLong("id"))
                .weight(rs.getInt("weight"))
                .cargoName(rs.getString("cargo_name"))
                .cargoType(CargoType.valueOf(rs.getString("cargo_type")))
                .paid(rs.getBoolean("paid"))
                .price(rs.getLong("price"))
                .route(new Route(
                        rs.getLong("route_id"),
                        rs.getString("start_city"),
                        rs.getString("end_city"),
                        rs.getInt("distance_in_km")))
                .shippingEnd(LocalDate.parse(rs.getString("shipping_end")))
                .shippingStart(LocalDate.parse(rs.getString("shipping_start")))
                .user(User.builder()
                        .email(rs.getString("email"))
                        .id(rs.getInt("user_id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .password(rs.getString("password"))
                        .roles("USER")
                        .build())
                .state(OrderStatus.valueOf(rs.getString("state")))
                .build();
        return Optional.of(order);
    }

    @Override
    public Order makeUnique(Map<Long, Order> cache,
                            Order order) {
        cache.putIfAbsent(order.getId(), order);
        return cache.get(order.getId());
    }
}