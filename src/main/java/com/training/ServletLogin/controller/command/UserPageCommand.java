package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.entity.User;
import com.training.ServletLogin.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UserPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(UserPageCommand.class);
    OrderService orderService;

    public UserPageCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        User user = (User) request.getSession(true).getAttribute("loggedUser");

        logger.info("Getting all orders");
        request.getSession().setAttribute("userOrders", orderService.getAllOrdersOfUser(user).getOrdersList());

        return "/WEB-INF/user-page.jsp";
    }
}