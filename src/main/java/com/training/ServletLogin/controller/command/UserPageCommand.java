package com.training.ServletLogin.controller.command;

import javax.servlet.http.HttpServletRequest;

public class UserPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return "/WEB-INF/user-page.jsp";
    }
}