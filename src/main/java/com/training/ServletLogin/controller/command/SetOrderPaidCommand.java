package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SetOrderPaidCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SetOrderPaidCommand.class);
    private OrderService orderService;

    public SetOrderPaidCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        long id = Long.parseLong(request.getParameter("order"));

        Order order = orderService.findOrderById(id).orElseThrow(RuntimeException::new);
        logger.info("Order found");
        orderService.setOrderPaid(order);
        return "redirect:/user/page";
    }
}
