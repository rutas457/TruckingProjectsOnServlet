package com.training.ServletLogin.dao;

import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderDao extends GenericDao<Order> {
    Optional<Order> findById(Long id);

    List<Order> findAllByUser(User user);
}
