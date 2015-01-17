package com.epam.bb.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    static Map<String, Action> actions;

    static {
        actions = new HashMap<String, Action>();
//        NullPointerException - actions == null
        actions.put("GET/", new ShowPageAction("welcome"));
        actions.put("GET/login", new ShowPageAction("login"));
        actions.put("POST/login", new LoginAction());
        actions.put("GET/success", new ShowPageAction("success"));
    }

    public static Action getAction(String command) {
        return actions.get(command);
    }
}
