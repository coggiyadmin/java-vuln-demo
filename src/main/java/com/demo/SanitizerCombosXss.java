package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Combinations #6/#7/#8 — SANITIZER × XSS (CWE-79). */
public class SanitizerCombosXss {
    private static String stripCmd(String s) { return s.replace(";", ""); }
    private static String sanitize(String s) { return s; }
    private static String escapeHtml(String s) { return s.replace("<", "_"); }
    public void wrong(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.getWriter().write("<p>" + stripCmd(req.getParameter("q")) + "</p>"); // CWE-79
    }
    public void fake(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.getWriter().write("<p>" + sanitize(req.getParameter("q")) + "</p>"); // CWE-79
    }
    public void wrapped(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.getWriter().write("<p>" + escapeHtml(req.getParameter("q")) + "</p>"); // expect 0
    }
}
