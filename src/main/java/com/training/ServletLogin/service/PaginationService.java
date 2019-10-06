package com.training.ServletLogin.service;

import com.training.ServletLogin.dao.DaoFactory;
import com.training.ServletLogin.dao.OrderDao;
import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.User;
import com.training.ServletLogin.utils.Pagination;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaginationService {
    private static final Logger logger = LogManager.getLogger(OrderService.class);

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Pagination<Order> getOrdersPage(User user, int page) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findAllByUserPaginated(user, page);
        }
    }
}
