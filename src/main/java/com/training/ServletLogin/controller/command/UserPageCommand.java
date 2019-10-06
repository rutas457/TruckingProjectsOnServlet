package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.User;
import com.training.ServletLogin.service.PaginationService;
import com.training.ServletLogin.utils.Pagination;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(UserPageCommand.class);
    private PaginationService pagination;

    public UserPageCommand(PaginationService pagination) {
        this.pagination = pagination;
    }

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession(true).getAttribute("loggedUser");

        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            logger.error(e);
        }
        Pagination<Order> currentPage = pagination.getOrdersPage(user, page);
        request.getSession().setAttribute("userOrders", currentPage.getList());
        if (currentPage.getNumberOfPages() > 0) {
            request.getSession().setAttribute("pages", IntStream
                    .rangeClosed(1, currentPage.getNumberOfPages())
                    .boxed()
                    .collect(Collectors.toList()));
        }

        return "/WEB-INF/user-page.jsp";
    }
}