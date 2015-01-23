package com.epam.bb.action;

import com.epam.bb.database.Implementation.JdbcDaoFactory;
import com.epam.bb.database.dao.DaoCommand;
import com.epam.bb.database.dao.DaoFactory;
import com.epam.bb.database.dao.DaoManager;
import com.epam.bb.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction implements Action {
    private ActionResult login = new ActionResult("login");
    private ActionResult success = new ActionResult("success", true);
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        final String username = req.getParameter(USERNAME);
        final String password = req.getParameter(PASSWORD);
        //TODO: Validation
        User user = null;

        JdbcDaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory();
        try {
            user = (User) jdbcDaoFactory.getDaoManager().executeAndClose(new DaoCommand() {
                @Override
                public Object execute(DaoManager daoManager) throws Exception {
                    return daoManager.getUserDao().findByUsernameAndPassword(username, password);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            req.setAttribute("loginCheckError", "login.or.password");// second parameter is key in Resourcebundle(WM proj)//TODO with resource bundle
            return login;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        return success;

    }
}





