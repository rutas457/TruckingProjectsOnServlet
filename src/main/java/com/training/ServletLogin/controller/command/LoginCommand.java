package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.entity.User;
import com.training.ServletLogin.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);
    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        if (email == null || email.equals("") || pass == null || pass.equals("")) {
            return "/index.jsp";
        }
        Optional<User> user = userService.findByEmail(email);
        if (checkUserIsLogged(request, email)) {
            return "/error.jsp";
        }
        if (user.isPresent() && user.get().getPassword().equals(pass)) {
            request.getSession(true).setAttribute("loggedUser", user.get());
            request.getSession(true).setAttribute("loggedUserEmail", user.get().getEmail());
            logger.info("User " + user + " logged successfully.");
            if (user.get().getRole().equals("ADMIN")) {
                return "redirect:/admin/all-orders";
            }
            return "redirect:/user/page";
        }
        logger.info("Invalid attempt of login user:'" + email + "'");
        return "/index.jsp#myModal";
    }

    static boolean checkUserIsLogged(HttpServletRequest request, String userName) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if (loggedUsers.stream().anyMatch(userName::equals)) {
            return true;
        }
        loggedUsers.add(userName);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }
}
