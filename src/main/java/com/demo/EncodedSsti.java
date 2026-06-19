package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #13 — ENCODED PAYLOAD × ssti. */
public class EncodedSsti {

    public void b64(HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws Exception {
        String n = new String(java.util.Base64.getDecoder().decode(req.getParameter("d")));
        org.apache.velocity.app.Velocity.evaluate(null, res.getWriter(), "v", "<p>" + n + "</p>"); // CWE-1336
    }
    public void url(HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws Exception {
        String n = java.net.URLDecoder.decode(req.getParameter("d"), "UTF-8");
        org.apache.velocity.app.Velocity.evaluate(null, res.getWriter(), "v", "<p>" + n + "</p>"); // CWE-1336
    }
}
