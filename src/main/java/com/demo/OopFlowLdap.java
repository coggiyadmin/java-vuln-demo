package com.demo;

import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #5 — OOP OBJECT FLOW × LDAP INJECTION (CWE-90). Constructor-injected
 * taint stored in a field, used to build a search filter. NO finding = FALSE NEGATIVE.
 */
public class OopFlowLdap {

    private final String user;

    public OopFlowLdap(HttpServletRequest req) {
        this.user = req.getParameter("user");
    }

    public String getUser() {
        return this.user;
    }

    public NamingEnumeration<SearchResult> searchDirect(DirContext ctx) throws Exception {
        return ctx.search("ou=people", "(uid=" + this.user + ")", new SearchControls());   // CWE-90
    }

    public NamingEnumeration<SearchResult> searchViaGetter(DirContext ctx) throws Exception {
        return ctx.search("ou=people", "(uid=" + getUser() + ")", new SearchControls());   // CWE-90
    }
}
