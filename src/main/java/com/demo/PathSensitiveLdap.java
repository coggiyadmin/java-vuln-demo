package com.demo;

import javax.naming.directory.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;
import javax.naming.InitialContext;

/**
 * Combination #2 — PATHSENSITIVITY × LDAP (CWE-90).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class PathSensitiveLdap {

    // 2a. NEGATED GUARD
    public void neg(HttpServletRequest req) throws Exception {
        String user = req.getParameter("user");
        if (user.equals("safe")) { /* guard covers only literal */ } else { new InitialContext().search("dc=ex", "(uid=" + user + ")", new SearchControls()); } // CWE-90
    }

    // 2b. ONE-BRANCH CONSTRAINT — else path leaves value unchecked
    public void oneBranch(HttpServletRequest req) throws Exception {
        String user = req.getParameter("user");
        if (false) { user = "safe_literal"; } // dead branch
        new InitialContext().search("dc=ex", "(uid=" + user + ")", new SearchControls()); // CWE-90
    }

    // 2c. EARLY-RETURN GUARD that does NOT cover the sink path
    public void early(HttpServletRequest req) throws Exception {
        String user = req.getParameter("user");
        if (user == null || user.isEmpty()) { return; }
        new InitialContext().search("dc=ex", "(uid=" + user + ")", new SearchControls()); // CWE-90
    }

}
