package com.demo;

import javax.xml.parsers.*;
import java.io.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #2 — PATHSENSITIVITY × XXE (CWE-611).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class PathSensitiveXxe {

    // 2a. NEGATED GUARD
    public void neg(HttpServletRequest req) throws Exception {
        String xml = req.getParameter("xml");
        if (xml.equals("safe")) { /* guard covers only literal */ } else { DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes())); } // CWE-611
    }

    // 2b. ONE-BRANCH CONSTRAINT — else path leaves value unchecked
    public void oneBranch(HttpServletRequest req) throws Exception {
        String xml = req.getParameter("xml");
        if (false) { xml = "safe_literal"; } // dead branch
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes())); // CWE-611
    }

    // 2c. EARLY-RETURN GUARD that does NOT cover the sink path
    public void early(HttpServletRequest req) throws Exception {
        String xml = req.getParameter("xml");
        if (xml == null || xml.isEmpty()) { return; }
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes())); // CWE-611
    }

}
