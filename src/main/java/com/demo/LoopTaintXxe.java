package com.demo;

import javax.xml.parsers.*;
import java.io.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #3 — LOOPTAINT × XXE (CWE-611).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class LoopTaintXxe {

    // 3a. ARRAY ELEMENT BUILT IN LOOP
    public void viaList(HttpServletRequest req) throws Exception {
        String[] in = req.getParameterValues("xml");
        String[] items = new String[in.length];
        for (int i = 0; i < in.length; i++) { items[i] = in[i]; }
        String xml = items[0];
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes())); // CWE-611
    }

    // 3b. STRING ACCUMULATOR
    public void viaAccum(HttpServletRequest req) throws Exception {
        String xml = "";
        for (String x : req.getParameterValues("xml")) { xml += x; }
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes())); // CWE-611
    }

    // 3c. ITERATE-AND-SINK
    public void viaIter(HttpServletRequest req) throws Exception {
        for (String xml : req.getParameterValues("xml")) {
            DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes())); // CWE-611 per iteration
        }
    }

}
