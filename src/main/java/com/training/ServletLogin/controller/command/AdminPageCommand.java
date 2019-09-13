package com.training.ServletLogin.controller.command;

import javax.servlet.http.HttpServletRequest;

public class AdminPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin-page.jsp";
    }
}
