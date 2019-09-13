package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LogoutCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LogoutCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");
        String currentUser = (String) session.getAttribute("loggedUserEmail");
        loggedUsers.remove(currentUser);

        session.setAttribute("loggedUser", null);

        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);

        logger.info("User " + currentUser +" successfully logged out");
        return "redirect:/login";
    }
}
