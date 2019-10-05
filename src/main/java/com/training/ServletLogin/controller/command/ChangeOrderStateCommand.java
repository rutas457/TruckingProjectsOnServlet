package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.enumerated.OrderStatus;
import com.training.ServletLogin.service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class ChangeOrderStateCommand implements Command {

    private OrderService orderService;

    public ChangeOrderStateCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String state = request.getParameter("action");
        long id = Long.parseLong(request.getParameter("order"));

        try {
            Order order = orderService.findOrderById(id).orElseThrow(RuntimeException::new);
            System.out.println("Order found");
            order.setState(OrderStatus.valueOf(state.toUpperCase()));
            orderService.updateState(order);
            System.out.println("Order updated");
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/all-orders";
        }
        return "redirect:/admin/all-orders";
    }
}
