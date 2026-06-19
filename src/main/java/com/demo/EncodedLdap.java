package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #13 — ENCODED PAYLOAD × ldap. */
public class EncodedLdap {

    public void b64(javax.naming.directory.DirContext ctx, HttpServletRequest req) throws Exception {
        String u = new String(java.util.Base64.getDecoder().decode(req.getParameter("d")));
        ctx.search("ou=people", "(uid=" + u + ")", new javax.naming.directory.SearchControls()); // CWE-90
    }
    public void url(javax.naming.directory.DirContext ctx, HttpServletRequest req) throws Exception {
        String u = java.net.URLDecoder.decode(req.getParameter("d"), "UTF-8");
        ctx.search("ou=people", "(uid=" + u + ")", new javax.naming.directory.SearchControls()); // CWE-90
    }
}
