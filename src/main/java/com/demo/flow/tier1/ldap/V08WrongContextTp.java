package com.demo.flow.tier1.ldap;
import javax.naming.directory.*;
import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;
public class V08WrongContextTp {
    public void search(HttpServletRequest req) throws Exception {
        String uid = StringEscapeUtils.escapeHtml4(req.getParameter("uid"));
        new InitialDirContext().search("dc=ex", "(uid=" + uid + ")", new SearchControls());
    }
}
