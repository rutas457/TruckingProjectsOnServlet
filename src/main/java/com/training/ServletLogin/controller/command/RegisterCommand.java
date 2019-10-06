package com.training.ServletLogin.controller.command;

import com.training.ServletLogin.dto.UserDTO;
import com.training.ServletLogin.service.UserService;
import com.training.ServletLogin.utils.ValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);
    private UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        if (ValidationUtils.correctInput(name, surname, pass, email)) {
            return "/index.jsp";
        }

        UserDTO userDTO = new UserDTO(name, surname, email, pass);
        userService.save(userDTO);
        logger.info("User " + userDTO.getEmail() + " registered successfully.");
        return "/index.jsp";
    }


}


