package com.demo;

import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — OopFlowLdap; LDAP filter metacharacters escaped. Expect 0 findings. */
public class SafeOopFlowLdap {

    private final String user;

    public SafeOopFlowLdap(HttpServletRequest req) {
        this.user = req.getParameter("user");
    }

    private static String esc(String s) {
        return s.replace("\\", "\\5c").replace("*", "\\2a")
                .replace("(", "\\28").replace(")", "\\29").replace("\0", "\\00");
    }

    public NamingEnumeration<SearchResult> searchDirect(DirContext ctx) throws Exception {
        return ctx.search("ou=people", "(uid=" + esc(this.user) + ")", new SearchControls());
    }
}
