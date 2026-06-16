package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;
import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

/**
 * DEMO FILE — intentional vulnerabilities for security scanner showcase.
 *
 * CWE findings : CWE-611 (XXE — external entity injection in XML parser),
 *                CWE-502 (Deserialization — ObjectInputStream with user data),
 *                CWE-90  (LDAP Injection — user input in LDAP filter),
 *                CWE-643 (XPath Injection — user input in XPath expression)
 * XML/LDAP     : demonstrates XML parsing and directory service vulnerabilities
 */
public class XmlLdapService {

    // CWE-611: XXE — DocumentBuilderFactory with external entities enabled
    public String parseXml(HttpServletRequest request) throws Exception {
        String body = new String(request.getInputStream().readAllBytes());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // External entities NOT disabled — allows reading local files via XML
        // Fix: factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(
            new ByteArrayInputStream(body.getBytes())
        );
        return doc.getDocumentElement().getTextContent();
    }

    // CWE-502: Deserialization — ObjectInputStream wrapping user-supplied bytes
    public Object deserializePayload(HttpServletRequest request) throws Exception {
        byte[] data = request.getInputStream().readAllBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();  // Executes gadget chains if data is crafted
    }

    // CWE-502: XStream deserialization without security restrictions
    public Object deserializeXml(HttpServletRequest request) throws Exception {
        String body = new String(request.getInputStream().readAllBytes());
        com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
        return xstream.fromXML(body);  // CWE-502: arbitrary class instantiation
    }

    // CWE-90: LDAP Injection — user input concatenated into LDAP filter
    public NamingEnumeration<?> searchUser(HttpServletRequest request) throws Exception {
        String username = request.getParameter("username");
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = new InitialDirContext(env);

        // Attacker sends username=*)(uid=*))(|(uid=* to bypass auth
        String filter = "(&(objectClass=user)(uid=" + username + "))";
        return ctx.search("dc=example,dc=com", filter, new SearchControls());
    }

    // CWE-90: LDAP injection via email parameter
    public boolean authenticateUser(HttpServletRequest request) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://ldap.example.com:389");
        DirContext ctx = new InitialDirContext(env);

        String filter = "(mail=" + email + ")";  // CWE-90: unsanitized email in filter
        NamingEnumeration<?> results = ctx.search("ou=users,dc=example,dc=com",
            filter, new SearchControls());
        return results.hasMore();
    }

    // CWE-643: XPath Injection — user input in XPath expression
    public String queryXml(HttpServletRequest request, org.w3c.dom.Document doc)
            throws Exception {
        String userId = request.getParameter("userId");
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        // Attacker sends userId=' or '1'='1 to bypass user lookup
        String expression = "/users/user[@id='" + userId + "']/email";
        return (String) xpath.evaluate(expression, doc, XPathConstants.STRING);
    }

    // CWE-643: XPath injection on document search
    public org.w3c.dom.NodeList searchDocument(HttpServletRequest request,
                                                org.w3c.dom.Document doc) throws Exception {
        String name = request.getParameter("name");
        XPathFactory factory = XPathFactory.newInstance();
        XPath xp = factory.newXPath();
        XPathExpression expr = xp.compile("//item[name='" + name + "']");
        return (org.w3c.dom.NodeList) expr.evaluate(doc, XPathConstants.NODESET);
    }
}
