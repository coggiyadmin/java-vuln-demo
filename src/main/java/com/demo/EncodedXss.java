package com.demo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/** Combination #13 — ENCODED × XSS (CWE-79). */
public class EncodedXss {
    public void b64(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String q = new String(java.util.Base64.getDecoder().decode(req.getParameter("d")));
        res.getWriter().write("<p>" + q + "</p>"); // CWE-79
    }
    public void url(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String q = java.net.URLDecoder.decode(req.getParameter("d"), "UTF-8");
        res.getWriter().write("<p>" + q + "</p>"); // CWE-79
    }
}
