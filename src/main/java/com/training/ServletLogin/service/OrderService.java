package com.training.ServletLogin.service;

import com.training.ServletLogin.dao.DaoFactory;
import com.training.ServletLogin.dao.OrderDao;
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

    public void save(OrderDTO orderDTO, User currentUser) {
        logger.info("In save method");
        Order order = Order.builder()
                .cargoType(orderDTO.getCargoType())
                .cargoName(orderDTO.getCargoName())
                .state(OrderStatus.CREATED)
                .weight(orderDTO.getWeight())
                .shippingStart(LocalDate.parse(orderDTO.getShippingStart()).plusDays(1))
                .shippingEnd(LocalDate.parse(orderDTO.getShippingEnd()).plusDays(1))
                .paid(false)
                .user(currentUser)
                .build();

        Route route = new Route(1L, "Kharkiv", "Kyiv", 500);
        order.setRoute(route);
        order.setPrice(order.calculateOrderPrice());
        logger.info(order.toString());
        try (OrderDao dao = daoFactory.createOrderDao()) {
            logger.info("Dao created");
            dao.create(order);
        }
    }

    public void save(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.create(order);
        }
    }


    public long getPrice(String from, String to, int weight, CargoType cargoType) {
        logger.info(from + " " + to);
        Route route;

        route = new Route(1L, "Kharkiv", "Kyiv", 500);


        Order order = Order.builder()
                .route(route)
                .weight(weight)
                .cargoType(cargoType)
                .build();
        return order.calculateOrderPrice();
    }

    public OrdersDTO getAllOrdersOfUser(User user) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            logger.info("All orders Dao Created");
            return new OrdersDTO(dao.findAllByUser(user));
        }
    }

    public OrdersDTO getAllUsersOrders() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return new OrdersDTO(dao.findAll());
        }
    }

    public Optional<Order> findOrderById(long id) {
        System.out.println("In find order");
        try (OrderDao dao = daoFactory.createOrderDao()) {
            logger.info("Find order dao created");
            return dao.findById(id);
        }
    }

    public void updateState(Order order) {
        logger.info("In update");
        try (OrderDao dao = daoFactory.createOrderDao()) {
            logger.info("Update dao created");
            dao.updateStateById(order);
        }
    }

    public void setOrderPaid(Order order) {
        logger.info("In pay method");
        try (OrderDao dao = daoFactory.createOrderDao()) {
            logger.info("Updating order paid state id=" + order.getId());
            dao.setPaidById(order);
        }
    }

}
