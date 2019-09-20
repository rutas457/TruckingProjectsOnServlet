package com.training.ServletLogin.dto;

import com.training.ServletLogin.entity.Order;

import java.util.List;

public class OrdersDTO {
    private List<Order> ordersList;

    public OrdersDTO(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }
}
