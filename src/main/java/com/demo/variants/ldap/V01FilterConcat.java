package com.demo.variants.ldap;

import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.servlet.http.HttpServletRequest;
public class V01FilterConcat {
    public void lookup(HttpServletRequest req, DirContext ctx) throws Exception {
        String uid = req.getParameter("uid");
        ctx.search("ou=people", "(uid=" + uid + ")", new SearchControls()); // SINK CWE-90
    }
}
