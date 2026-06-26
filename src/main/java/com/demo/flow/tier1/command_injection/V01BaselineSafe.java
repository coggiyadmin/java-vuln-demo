package com.demo.flow.tier1.command_injection;

import javax.servlet.http.HttpServletRequest;
public class V01BaselineSafe {
    public void run(HttpServletRequest req) throws Exception {
        String q = req.getParameter("q");
        Runtime.getRuntime().exec(new String[] {"grep", q, "/var/log/app.log"});
    }
}
