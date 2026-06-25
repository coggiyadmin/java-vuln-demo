package com.demo;

import javax.xml.xpath.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #3 — LOOPTAINT × XPATH (CWE-643).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class LoopTaintXpath {

    // 3a. ARRAY ELEMENT BUILT IN LOOP
    public void viaList(HttpServletRequest req) throws Exception {
        String[] in = req.getParameterValues("name");
        String[] items = new String[in.length];
        for (int i = 0; i < in.length; i++) { items[i] = in[i]; }
        String name = items[0];
        XPathFactory.newInstance().newXPath().evaluate("//user[name='" + name + "']", (Object) null); // CWE-643
    }

    // 3b. STRING ACCUMULATOR
    public void viaAccum(HttpServletRequest req) throws Exception {
        String name = "";
        for (String x : req.getParameterValues("name")) { name += x; }
        XPathFactory.newInstance().newXPath().evaluate("//user[name='" + name + "']", (Object) null); // CWE-643
    }

    // 3c. ITERATE-AND-SINK
    public void viaIter(HttpServletRequest req) throws Exception {
        for (String name : req.getParameterValues("name")) {
            XPathFactory.newInstance().newXPath().evaluate("//user[name='" + name + "']", (Object) null); // CWE-643 per iteration
        }
    }

}
