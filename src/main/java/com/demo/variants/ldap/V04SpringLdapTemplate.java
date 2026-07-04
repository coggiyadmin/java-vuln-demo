package com.demo.variants.ldap;

import org.springframework.ldap.core.LdapTemplate;
import javax.servlet.http.HttpServletRequest;
public class V04SpringLdapTemplate {
    public void springLdap(HttpServletRequest req, LdapTemplate ldap) {
        String user = req.getParameter("user"); // SOURCE
        ldap.search("", "(uid=" + user + ")", (Object ctx) -> null); // SINK CWE-90 Spring LDAP
    }
}
