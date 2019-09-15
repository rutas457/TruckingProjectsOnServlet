package com.training.ServletLogin.controller.command;

import javax.servlet.http.HttpServletRequest;

public class LandingCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/index.jsp";
    }
}
