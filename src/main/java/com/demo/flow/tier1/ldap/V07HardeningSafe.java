package com.demo.flow.tier1.ldap;
import javax.naming.directory.*;
import javax.servlet.http.*;
public class V07HardeningSafe {
    public void search(HttpServletRequest req) throws Exception {
        String uid = req.getParameter("uid");
        if (uid == null || uid.length() > 64 || !uid.matches("[a-zA-Z0-9_-]+"))
            throw new SecurityException();
        new InitialDirContext().search("dc=ex", "(uid=" + uid + ")", new SearchControls());
    }
}
