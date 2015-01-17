package com.epam.bb.action;

import com.epam.bb.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {
    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if ("user".equals(login) && "pass".equals(password)) {
            User user = new User(login, password); // из Дао получать, искать его по имени и пользователю в базе
            req.getSession().setAttribute("user", user);
            Cookie cookie = new Cookie("Locale", "ru");
            cookie.setMaxAge(500000);
            resp.addCookie(cookie);
            return new ActionResult("success", true);
        }
        req.setAttribute("login", login);
        return new ActionResult("login");
    }
}
