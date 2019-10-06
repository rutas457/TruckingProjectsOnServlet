package com.training.ServletLogin.dao;

import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.User;
import com.training.ServletLogin.utils.Pagination;

import java.util.List;
import java.util.Optional;

public interface OrderDao extends GenericDao<Order> {
    Optional<Order> findById(Long id);

    List<Order> findAllByUser(User user);

    Pagination<Order> findAllByUserPaginated(User user, int page);

    int getNumberOfRecordsByUserId(Integer id);

    void updateStateById(Order order);

    void setPaidById(Order order);
}
