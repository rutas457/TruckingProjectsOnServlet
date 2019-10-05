package com.training.ServletLogin;

import com.training.ServletLogin.controller.Servlet;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class TestServlet {
    private final static String path = "/user-order.jsp";

    @Test(expected = NullPointerException.class)
    public void testCheckUserIsLogged() throws ServletException, IOException {

        final Servlet servlet = new Servlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
        servlet.doGet(request, response);
    }
}
