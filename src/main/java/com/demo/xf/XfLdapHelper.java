package com.demo.xf;

import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class XfLdapHelper {
    public static NamingEnumeration<SearchResult> run(DirContext ctx, String user) throws Exception {
        return ctx.search("ou=people", "(uid=" + user + ")", new SearchControls()); // SINK CWE-90
    }
}
