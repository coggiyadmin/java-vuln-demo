package com.demo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/** Combination #2 — PATH-SENSITIVITY × XSS (CWE-79). */
public class PathSensitiveXss {
    public void neg(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String q = req.getParameter("q");
        if (q.contains("<")) res.getWriter().write("<p>" + q + "</p>"); // CWE-79
    }
}
