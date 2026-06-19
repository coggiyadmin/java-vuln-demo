package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #11 — FAN-OUT × ssti. */
public class FanoutSsti {

    public void fanout(HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws Exception {
        String n = req.getParameter("n");
        org.apache.velocity.app.Velocity.evaluate(null, res.getWriter(), "v1", "<p>" + n + "</p>"); // CWE-1336
        org.apache.velocity.app.Velocity.evaluate(null, res.getWriter(), "v2", "<h1>" + n + "</h1>"); // CWE-1336
        org.apache.velocity.app.Velocity.evaluate(null, res.getWriter(), "v3", "{set x="" + n + ""}{{x}}"); // CWE-1336
    }
}
