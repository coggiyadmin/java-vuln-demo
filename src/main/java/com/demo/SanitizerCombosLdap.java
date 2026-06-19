package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combinations #6/#7/#8 — SANITIZER × LDAP INJECTION (CWE-90). */
public class SanitizerCombosLdap {

    private static String escapeHtml(String s) { return s.replace("<", "_"); }
    private static String sanitize(String s) { return s; }
    private static String ldapSafe(String s) { return s.replace("(", "").replace(")", ""); }
    public void wrong(javax.naming.directory.DirContext ctx, HttpServletRequest req) throws Exception {
        ctx.search("ou=people", "(uid=" + escapeHtml(req.getParameter("user")) + ")", new javax.naming.directory.SearchControls()); // CWE-90
    }

    public void fake(javax.naming.directory.DirContext ctx, HttpServletRequest req) throws Exception {
        ctx.search("ou=people", "(uid=" + sanitize(req.getParameter("user")) + ")", new javax.naming.directory.SearchControls()); // CWE-90
    }

    public void wrapped(javax.naming.directory.DirContext ctx, HttpServletRequest req) throws Exception {
        ctx.search("ou=people", "(uid=" + ldapSafe(req.getParameter("user")) + ")", new javax.naming.directory.SearchControls()); // expect 0
    }
}
