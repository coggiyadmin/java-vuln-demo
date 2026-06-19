package com.demo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/** Combination #3 — LOOP × XSS (CWE-79). */
public class LoopTaintXss {
    public void loop(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String[] parts = req.getParameterValues("q");
        if (parts == null) return;
        for (String item : parts) {
            res.getWriter().write("<span>" + item + "</span>"); // CWE-79
        }
    }
}
