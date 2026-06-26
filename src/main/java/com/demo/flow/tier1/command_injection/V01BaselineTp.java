package com.demo.flow.tier1.command_injection;

import javax.servlet.http.HttpServletRequest;
public class V01BaselineTp {
    public void run(HttpServletRequest req) throws Exception {
        String q = req.getParameter("q"); // SOURCE
        Runtime.getRuntime().exec("grep " + q); // SINK CWE-78
    }
}
