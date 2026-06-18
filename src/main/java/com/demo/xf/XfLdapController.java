package com.demo.xf;

import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;

public class XfLdapController {
    public NamingEnumeration<SearchResult> handle(HttpServletRequest req, DirContext ctx) throws Exception {
        String user = req.getParameter("user");   // SOURCE
        return XfLdapHelper.run(ctx, user);        // cross-file call (CWE-90)
    }
}
