package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combinations #6/#7/#8 — SANITIZER × XXE (CWE-611). */
public class SanitizerCombosXxe {

    private static String escapeHtml(String s) { return s.replace("<", "_"); }
    private static String sanitize(String s) { return s; }
    public void wrong(HttpServletRequest req) throws Exception {
        javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(escapeHtml(req.getParameter("xml")).getBytes())); // CWE-611
    }

    public void fake(HttpServletRequest req) throws Exception {
        javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(sanitize(req.getParameter("xml")).getBytes())); // CWE-611
    }

    public void wrapped(HttpServletRequest req) throws Exception {
        javax.xml.parsers.DocumentBuilderFactory f = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        f.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        f.newDocumentBuilder().parse(new java.io.ByteArrayInputStream(req.getParameter("xml").getBytes())); // expect 0
    }
}
