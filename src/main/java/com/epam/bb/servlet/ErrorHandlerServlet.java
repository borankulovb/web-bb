package com.epam.bb.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorHandlerServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ErrorHandlerServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request
                .getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request
                .getAttribute("javax.servlet.error.servlet_name");
        String requestUri = (String) request
                .getAttribute("javax.servlet.error.request_uri");
        LOG.debug("throwable: {}", throwable);
        LOG.debug("status code: {}", statusCode);
        LOG.debug("servlet name: {}", servletName);
        LOG.debug("request uri: {}", requestUri);

        request.setAttribute("errorCode", statusCode);
        request.setAttribute("request uri", requestUri);

        request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

