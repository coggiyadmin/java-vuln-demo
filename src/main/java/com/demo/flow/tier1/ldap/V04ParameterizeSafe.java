package com.demo.flow.tier1.ldap;

import javax.naming.directory.*;
import javax.servlet.http.HttpServletRequest;
public class V04ParameterizeSafe {
    public void lookup(HttpServletRequest req, DirContext ctx) throws Exception {
        String uid = req.getParameter("uid");
        if (!uid.matches("[a-zA-Z0-9_-]+")) throw new SecurityException("forbidden");
        ctx.search("ou=people", "(uid=" + uid + ")", new SearchControls());
    }
}
