package com.demo.variants.ldap;

import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpServletRequest;
public class V02DnSearch {
    public void bind(HttpServletRequest req) throws Exception {
        String dn = req.getParameter("dn");
        new InitialDirContext().getAttributes(dn); // SINK CWE-90
    }
}
