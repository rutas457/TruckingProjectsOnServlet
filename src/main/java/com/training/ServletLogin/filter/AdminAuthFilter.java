package com.training.ServletLogin.filter;

import com.training.ServletLogin.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminAuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("loggedUser") != null && (((User) session.getAttribute("loggedUser")).getRole().equals("ADMIN")));

        String loginURI = httpRequest.getContextPath() + "/login";

        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);

        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
            dispatcher.forward(request, response);

        } else if (isLoggedIn || isLoginRequest) {
            chain.doFilter(request, response);

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/api/login");
            dispatcher.forward(request, response);

        }

    }

    public AdminAuthFilter() {
    }

    public void destroy() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
