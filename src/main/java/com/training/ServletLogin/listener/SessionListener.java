package com.training.ServletLogin.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HashSet<String> loggedUsers = (HashSet<String>) httpSessionEvent
                .getSession().getServletContext()
                .getAttribute("loggedUsers");
        String userName = (String) httpSessionEvent.getSession()
                .getAttribute("userName");
        loggedUsers.remove(userName);
        httpSessionEvent.getSession().setAttribute("loggedUsers", loggedUsers);
    }
}
