package com.demo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/** Combination #11 — FAN-OUT × XSS (CWE-79). */
public class FanoutXss {
    public void fanout(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String q = req.getParameter("q");
        res.getWriter().write("<p>" + q + "</p>"); // CWE-79
        res.getWriter().write("<h1>" + q + "</h1>"); // CWE-79
        res.getWriter().write("<span>" + q + "</span>"); // CWE-79
    }
}
