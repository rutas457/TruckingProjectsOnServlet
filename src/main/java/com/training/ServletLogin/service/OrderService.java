package com.training.ServletLogin.service;

import com.training.ServletLogin.controller.command.LoginCommand;
import com.training.ServletLogin.dao.DaoFactory;
import com.training.ServletLogin.dao.OrderDao;
import com.training.ServletLogin.dao.RouteDao;
import com.training.ServletLogin.dto.OrderDTO;
import com.training.ServletLogin.dto.OrdersDTO;
import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.Route;
import com.training.ServletLogin.entity.User;
import com.training.ServletLogin.entity.enumerated.CargoType;
import com.training.ServletLogin.entity.enumerated.OrderStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Optional;

public class OrderService {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    private DaoFactory daoFactory = DaoFactory.getInstance();

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

        logger.info(order.toString());
        order.setUser(new UserService().findByEmail(currentUser).orElseThrow(RuntimeException::new));

        try (RouteDao dao = daoFactory.createRouteDao()) {
            order.setRoute(dao.findByStartCityAndEndCity(orderDTO.getToCity(), orderDTO.getFromCity())
                    .orElse(dao.findByStartCityAndEndCity(orderDTO.getFromCity(), orderDTO.getToCity())
                            .orElseThrow(RuntimeException::new)));
        }
        order.setPrice(order.calculateOrderPrice());

        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.create(order);
        }
    }

    public long getPrice(String from, String to, int weight, CargoType cargoType) {
        logger.info(from + " " + to);
        Route route;
        try(RouteDao dao = daoFactory.createRouteDao()) {
           route = dao.findByStartCityAndEndCity(to, from)
                    .orElse(dao.findByStartCityAndEndCity(from, to)
                            .orElseThrow(RuntimeException::new));
        }

        Order order = Order.builder()
                .route(route)
                .weight(weight)
                .cargoType(cargoType)
                .build();
        return order.calculateOrderPrice();
    }

    public OrdersDTO getAllOrdersOfUser(User user) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return new OrdersDTO(dao.findAllByUser(user));
        }
    }

    public OrdersDTO getAllUsersOrders() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return new OrdersDTO(dao.findAll());
        }
    }

    public Optional<Order> findOrderById(long id) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findById(id);
        }
    }
}
