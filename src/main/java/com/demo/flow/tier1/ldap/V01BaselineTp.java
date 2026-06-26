package com.demo.flow.tier1.ldap;

import javax.naming.directory.*;
import javax.servlet.http.HttpServletRequest;
public class V01BaselineTp {
    public void lookup(HttpServletRequest req, DirContext ctx) throws Exception {
        String uid = req.getParameter("uid"); // SOURCE
        ctx.search("ou=people", "(uid=" + uid + ")", new SearchControls()); // SINK CWE-90
    }
}
