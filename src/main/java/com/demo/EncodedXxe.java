package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #13 — ENCODED PAYLOAD × xxe. */
public class EncodedXxe {

    public void b64(HttpServletRequest req) throws Exception {
        String x = new String(java.util.Base64.getDecoder().decode(req.getParameter("d")));
        javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(x.getBytes())); // CWE-611
    }
    public void url(HttpServletRequest req) throws Exception {
        String x = java.net.URLDecoder.decode(req.getParameter("d"), "UTF-8");
        javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(x.getBytes())); // CWE-611
    }
}
