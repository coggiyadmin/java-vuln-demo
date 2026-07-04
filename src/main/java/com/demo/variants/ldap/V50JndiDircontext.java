package com.demo.variants.ldap;

import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.servlet.http.HttpServletRequest;
public class V50JndiDircontext {
    public void search(HttpServletRequest req, InitialDirContext ctx) throws Exception {
        String user = req.getParameter("user"); // SOURCE
        ctx.search("ou=people", "(uid=" + user + ")", new SearchControls()); // SINK CWE-90 JNDI DirContext
    }
}
