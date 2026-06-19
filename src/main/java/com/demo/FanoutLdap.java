package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #11 — FAN-OUT × ldap. */
public class FanoutLdap {

    public void fanout(javax.naming.directory.DirContext ctx, HttpServletRequest req) throws Exception {
        String u = req.getParameter("u");
        javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
        ctx.search("ou=people", "(uid=" + u + ")", sc); // CWE-90
        ctx.search("ou=people", "(cn=" + u + ")", sc); // CWE-90
        ctx.search("ou=people", "(mail=" + u + ")", sc); // CWE-90
    }
}
