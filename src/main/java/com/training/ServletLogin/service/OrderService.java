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


/**
 * The {@code OrderService } class contains business logic of the orders processing
 */
public class OrderService {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     * Saves order of a current user into database
     *
     * @param orderDTO    order made by user
     * @param currentUser user from session attribute
     */
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

    /**
     * Updates the order entity in the database
     *
     * @param order order to update
     */
    public void update(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.create(order);
        }
    }


    /**
     * Calculates the price of the order depending on the input params
     *
     * @param from      city of departure
     * @param to        city of arrival
     * @param weight    weight of the cargo
     * @param cargoType type of the cargo
     * @return cargo price
     */
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

    /**
     * @param user current user
     * @return all orders of user
     */
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


    /**
     * Updates the state of the order
     *
     * @param order chosen order from list
     */
    public void updateState(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.updateStateById(order);
        }
    }

    /**
     * Sets order paid state in the database
     *
     * @param order to pay
     */
    public void setOrderPaid(Order order) {
        logger.info("In pay method");
        try (OrderDao dao = daoFactory.createOrderDao()) {
            logger.info("Updating order paid state id=" + order.getId());
            dao.setPaidById(order);
        }
    }

}
