package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combinations #6/#7/#8 — SANITIZER × LOG INJECTION (CWE-117). */
public class SanitizerCombosLogInj {

    private static String escapeHtml(String s) { return s.replace("<", "_"); }
    private static String sanitize(String s) { return s; }
    private static String stripCrlf(String s) { return s.replace("\r", "").replace("\n", ""); }
    public void wrong(HttpServletRequest req) {
        java.util.logging.Logger.getLogger("app").info("a " + escapeHtml(req.getParameter("user"))); // CWE-117
    }

    public void fake(HttpServletRequest req) {
        java.util.logging.Logger.getLogger("app").info("a " + sanitize(req.getParameter("user"))); // CWE-117
    }

    public void wrapped(HttpServletRequest req) {
        java.util.logging.Logger.getLogger("app").info("a " + stripCrlf(req.getParameter("user"))); // expect 0
    }
}
