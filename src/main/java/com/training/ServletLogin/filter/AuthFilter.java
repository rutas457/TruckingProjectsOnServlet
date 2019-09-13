package com.training.ServletLogin.filter;

import com.training.ServletLogin.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {
    private HttpServletRequest httpRequest;

    private static final String[] loginRequiredURLs = {
            "/api/user/page", "/api/admin/page"
    };

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());


        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("loggedUser") != null);

        if (path.startsWith("/api/admin/") && isLoggedIn && ((User) (session.getAttribute("loggedUser"))).getRole().equals("ADMIN")) {
            chain.doFilter(request, response);
            return;
        }


        String loginURI = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            httpRequest.getRequestDispatcher("/").forward(request, response);

        } else if (!isLoggedIn && isLoginRequired()) {
            String loginPage = "/api/login";
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }


    private boolean isLoginRequired() {
        String requestURL = httpRequest.getRequestURL().toString();

        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }

        return false;
    }

    public AuthFilter() {
    }

    public void destroy() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}