package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #11 — FAN-OUT × xxe. */
public class FanoutXxe {

    public void fanout(HttpServletRequest req) throws Exception {
        String x = req.getParameter("xml");
        javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(x.getBytes())); // CWE-611
        javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(("<r>" + x + "</r>").getBytes())); // CWE-611
        javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(x.getBytes())); // CWE-611
    }
}
