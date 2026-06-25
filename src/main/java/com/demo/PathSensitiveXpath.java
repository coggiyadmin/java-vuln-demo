package com.demo;

import javax.xml.xpath.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #2 — PATHSENSITIVITY × XPATH (CWE-643).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class PathSensitiveXpath {

    // 2a. NEGATED GUARD
    public void neg(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        if (name.equals("safe")) { /* guard covers only literal */ } else { XPathFactory.newInstance().newXPath().evaluate("//user[name='" + name + "']", (Object) null); } // CWE-643
    }

    // 2b. ONE-BRANCH CONSTRAINT — else path leaves value unchecked
    public void oneBranch(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        if (false) { name = "safe_literal"; } // dead branch
        XPathFactory.newInstance().newXPath().evaluate("//user[name='" + name + "']", (Object) null); // CWE-643
    }

    // 2c. EARLY-RETURN GUARD that does NOT cover the sink path
    public void early(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        if (name == null || name.isEmpty()) { return; }
        XPathFactory.newInstance().newXPath().evaluate("//user[name='" + name + "']", (Object) null); // CWE-643
    }

}
