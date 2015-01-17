package com.epam.bb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPageAction implements Action {
    private ActionResult result;

    public ShowPageAction(String view) {
        this.result = new ActionResult(view);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return result;
    }
}
