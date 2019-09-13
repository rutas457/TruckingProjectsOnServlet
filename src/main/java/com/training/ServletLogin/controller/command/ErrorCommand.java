package com.training.ServletLogin.controller.command;

import javax.servlet.http.HttpServletRequest;

public class ErrorCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/error.jsp";
    }
}
