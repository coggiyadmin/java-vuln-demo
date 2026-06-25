package com.demo;

import javax.naming.directory.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;
import javax.naming.InitialContext;

/**
 * Combination #3 — LOOPTAINT × LDAP (CWE-90).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class LoopTaintLdap {

    // 3a. ARRAY ELEMENT BUILT IN LOOP
    public void viaList(HttpServletRequest req) throws Exception {
        String[] in = req.getParameterValues("user");
        String[] items = new String[in.length];
        for (int i = 0; i < in.length; i++) { items[i] = in[i]; }
        String user = items[0];
        new InitialContext().search("dc=ex", "(uid=" + user + ")", new SearchControls()); // CWE-90
    }

    // 3b. STRING ACCUMULATOR
    public void viaAccum(HttpServletRequest req) throws Exception {
        String user = "";
        for (String x : req.getParameterValues("user")) { user += x; }
        new InitialContext().search("dc=ex", "(uid=" + user + ")", new SearchControls()); // CWE-90
    }

    // 3c. ITERATE-AND-SINK
    public void viaIter(HttpServletRequest req) throws Exception {
        for (String user : req.getParameterValues("user")) {
            new InitialContext().search("dc=ex", "(uid=" + user + ")", new SearchControls()); // CWE-90 per iteration
        }
    }

}
