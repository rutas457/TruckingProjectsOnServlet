package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.dto.OrderDTO;
import com.training.ServletLogin.entity.User;
import com.training.ServletLogin.entity.enumerated.CargoType;
import com.training.ServletLogin.service.OrderService;
import com.training.ServletLogin.utils.ValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class OrderCommand implements Command {

    private static final Logger logger = LogManager.getLogger(OrderCommand.class);
    private OrderService orderService;

    public OrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String cargoName = request.getParameter("cargoName");
        String fromCity = request.getParameter("fromCity");
        String toCity = request.getParameter("toCity");
        String shippingStart = request.getParameter("shippingStart");
        String shippingEnd = request.getParameter("shippingEnd");
        String cargoType = request.getParameter("cargoType");

        if (!ValidationUtils.correctInput(cargoName, cargoType, fromCity, toCity, shippingEnd, shippingStart)) {
            return "/WEB-INF/user-order.jsp";
        }
        Integer weight = Integer.valueOf(request.getParameter("weight"));

        try {
            OrderDTO orderDTO = OrderDTO.builder()
                    .to(toCity)
                    .cargoName(cargoName)
                    .cargoType(CargoType.valueOf(cargoType.toUpperCase()))
                    .from(fromCity)
                    .shippingEnd(shippingEnd)
                    .shippingStart(shippingStart)
                    .weight(weight)
                    .build();

            logger.info(orderDTO.toString());
            orderService.save(orderDTO, ((User) request.getSession(true).getAttribute("loggedUser")));

            logger.info("Order was successfully committed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user/page";
    }
}



