package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.enumerated.OrderStatus;
import com.training.ServletLogin.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class AdminOrdersListCommand implements Command {
    private OrderService orderService;

    public AdminOrdersListCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        List<Order> orders = orderService.getAllUsersOrders().getOrdersList();
        request.getSession().setAttribute("newOrders", orders.stream()
                .filter(x -> x.getState().equals(OrderStatus.CREATED))
                .collect(Collectors.toList()));

        request.getSession().setAttribute("ordersInProcess", orders.stream()
                .filter(x -> x.getState().equals(OrderStatus.PROCESSING))
                .collect(Collectors.toList()));

        request.getSession().setAttribute("completedOrders", orders.stream()
                .filter(x -> x.getState().equals(OrderStatus.COMPLETED))
                .collect(Collectors.toList()));

        request.getSession().setAttribute("rejectedOrders", orders.stream()
                .filter(x -> x.getState().equals(OrderStatus.REJECTED))
                .collect(Collectors.toList()));

        return "/WEB-INF/admin-orders.jsp";
    }
}
