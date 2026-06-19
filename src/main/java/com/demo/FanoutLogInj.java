package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #11 — FAN-OUT × loginj. */
public class FanoutLogInj {

    public void fanout(HttpServletRequest req) {
        String u = req.getParameter("u");
        java.util.logging.Logger.getLogger("a").info("a " + u); // CWE-117
        java.util.logging.Logger.getLogger("b").warning("b " + u); // CWE-117
        java.util.logging.Logger.getLogger("c").severe("c " + u); // CWE-117
    }
}
