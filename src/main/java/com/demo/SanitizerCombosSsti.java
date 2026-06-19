package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combinations #6/#7/#8 — SANITIZER × SSTI (CWE-1336). */
public class SanitizerCombosSsti {

    private static String escapeHtml(String s) { return s.replace("<", "_"); }
    private static String sanitize(String s) { return s; }
    public void wrong(HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws Exception {
        org.apache.velocity.app.Velocity.evaluate(null, res.getWriter(), "v", "<p>" + escapeHtml(req.getParameter("name")) + "</p>"); // CWE-1336
    }

    public void fake(HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws Exception {
        org.apache.velocity.app.Velocity.evaluate(null, res.getWriter(), "v", "<p>" + sanitize(req.getParameter("name")) + "</p>"); // CWE-1336
    }

    public void wrapped(HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws Exception {
        org.apache.velocity.app.Velocity.evaluate(null, res.getWriter(), "v", "<p>${name}</p>", new org.apache.velocity.VelocityContext("name", req.getParameter("name"))); // expect 0
    }
}
