package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #11 — FAN-OUT × xpath. */
public class FanoutXPath {

    public void fanout(javax.xml.xpath.XPath xp, HttpServletRequest req) throws Exception {
        String n = req.getParameter("n");
        xp.evaluate("//user[name='" + n + "']", new org.xml.sax.InputSource()); // CWE-643
        xp.evaluate("//account[name='" + n + "']", new org.xml.sax.InputSource()); // CWE-643
        xp.evaluate("//*[@id='" + n + "']", new org.xml.sax.InputSource()); // CWE-643
    }
}
