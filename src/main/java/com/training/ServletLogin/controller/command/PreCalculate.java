package com.training.ServletLogin.controller.command;

import javax.servlet.http.HttpServletRequest;

public class PreCalculate implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String weight = request.getParameter("weight");

        request.getSession(true).setAttribute("fromCity", from);
        request.getSession(true).setAttribute("toCity", to);
        request.getSession(true).setAttribute("weight", weight);
        return "/guest-calculate.jsp";
    }
}
