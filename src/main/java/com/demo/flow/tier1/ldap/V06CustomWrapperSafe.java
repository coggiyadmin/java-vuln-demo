package com.demo.flow.tier1.ldap;
import javax.naming.directory.*;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace(")", ""); }
    public void search(HttpServletRequest req) throws Exception {
        String uid = companySanitize(req.getParameter("uid"));
        new InitialDirContext().search("dc=ex", "(uid=" + uid + ")", new SearchControls());
    }
}
