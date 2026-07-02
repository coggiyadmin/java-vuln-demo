package com.demo.variants.ldap;

import com.unboundid.ldap.sdk.LDAPConnection;
import javax.servlet.http.HttpServletRequest;
public class V03ActivedirectoryLib {
    public void unboundid(HttpServletRequest req) throws Exception {
        String user = req.getParameter("user");
        new LDAPConnection("localhost", 389).search("ou=users", com.unboundid.ldap.sdk.SearchScope.SUB,
            "(uid=" + user + ")"); // SINK CWE-90 unboundid
    }
}
