package com.training.ServletLogin.controller;

import com.training.ServletLogin.controller.command.*;
import com.training.ServletLogin.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Servlet extends HttpServlet {

    private UserService userService = new UserService();
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig) {
        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());
        commands.put("login", new LoginCommand(new UserService()));
        commands.put("error", new ErrorCommand());
        commands.put("register", new RegisterCommand(new UserService()));
        commands.put("admin/page", new AdminPageCommand());
        commands.put("user/page", new UserPageCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("landing", new LandingCommand());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/api/", "");
        System.out.println(path);
        Command command = commands.getOrDefault(path,
                (r) -> "/index.jsp");
        String page = command.execute(request);
        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect:", "/api"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}