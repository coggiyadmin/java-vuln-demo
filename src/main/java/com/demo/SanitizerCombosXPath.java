package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combinations #6/#7/#8 — SANITIZER × XPATH INJECTION (CWE-643). */
public class SanitizerCombosXPath {

    private static String escapeHtml(String s) { return s.replace("<", "_"); }
    private static String sanitize(String s) { return s; }
    private static String xpathSafe(String s) { return s.replace("'", ""); }
    public void wrong(javax.xml.xpath.XPath xp, HttpServletRequest req) throws Exception {
        xp.evaluate("//user[name='" + escapeHtml(req.getParameter("name")) + "']", new org.xml.sax.InputSource()); // CWE-643
    }

    public void fake(javax.xml.xpath.XPath xp, HttpServletRequest req) throws Exception {
        xp.evaluate("//user[name='" + sanitize(req.getParameter("name")) + "']", new org.xml.sax.InputSource()); // CWE-643
    }

    public void wrapped(javax.xml.xpath.XPath xp, HttpServletRequest req) throws Exception {
        xp.evaluate("//user[name='" + xpathSafe(req.getParameter("name")) + "']", new org.xml.sax.InputSource()); // expect 0
    }
}
