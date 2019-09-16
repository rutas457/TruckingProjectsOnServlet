package com.training.ServletLogin.service;

import com.training.ServletLogin.dao.DaoFactory;
import com.training.ServletLogin.dao.OrderDao;
import com.training.ServletLogin.dao.RouteDao;
import com.training.ServletLogin.dto.OrderDTO;
import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.enumerated.OrderStatus;

import java.time.LocalDate;

public class OrderService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public boolean save(OrderDTO orderDTO, String currentUser) {

        Order order = Order.builder()
                .cargoType(orderDTO.getCargoType())
                .cargoName(orderDTO.getCargoName())
                .state(OrderStatus.CREATED)
                .weight(orderDTO.getWeight())
                .shippingStart(LocalDate.parse(orderDTO.getShippingStart()).plusDays(1))
                .shippingEnd(LocalDate.parse(orderDTO.getShippingEnd()).plusDays(1))
                .paid(false)
                .build();
        order.setPrice(order.calculateOrderPrice());

        order.setUser(new UserService().findByEmail(currentUser).orElseThrow(RuntimeException::new));

        try (RouteDao dao = daoFactory.createRouteDao()) {
            order.setRoute(dao.findByStartCityAndEndCity(orderDTO.getToCity(), orderDTO.getFromCity())
                    .orElse(dao.findByStartCityAndEndCity(orderDTO.getFromCity(), orderDTO.getToCity())
                            .orElseThrow(RuntimeException::new)));
        }

        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.create(order);
        }
    }
}
