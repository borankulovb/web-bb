package com.epam.bb.servlet;

import com.epam.bb.action.Action;
import com.epam.bb.action.ActionFactory;
import com.epam.bb.action.ActionResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionName = req.getMethod() + req.getPathInfo();

        Action action = ActionFactory.getAction(actionName);

        ActionResult result = action.execute(req, resp);

        if (result.isRedirect()) {
            resp.sendRedirect(req.getContextPath() + "/do/" + result.getView());
            return;
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/" + result.getView() + ".jsp");
        requestDispatcher.forward(req, resp);
    }
}
