package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #13 — ENCODED PAYLOAD × xpath. */
public class EncodedXPath {

    public void b64(javax.xml.xpath.XPath xp, HttpServletRequest req) throws Exception {
        String n = new String(java.util.Base64.getDecoder().decode(req.getParameter("d")));
        xp.evaluate("//user[name='" + n + "']", new org.xml.sax.InputSource()); // CWE-643
    }
    public void url(javax.xml.xpath.XPath xp, HttpServletRequest req) throws Exception {
        String n = java.net.URLDecoder.decode(req.getParameter("d"), "UTF-8");
        xp.evaluate("//user[name='" + n + "']", new org.xml.sax.InputSource()); // CWE-643
    }
}
