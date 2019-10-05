package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.entity.enumerated.CargoType;
import com.training.ServletLogin.service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class PreCalculate implements Command {
    OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request) {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String weight = request.getParameter("weight");
        double price = orderService.getPrice(from, to, Integer.valueOf(weight), CargoType.STANDARD);

        request.getSession(true).setAttribute("fromCity", from);
        request.getSession(true).setAttribute("toCity", to);
        request.getSession(true).setAttribute("weight", weight);
        request.getSession(true).setAttribute("price", price);
        return "/guest-calculate.jsp";
    }
}
