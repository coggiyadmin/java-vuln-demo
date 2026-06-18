package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

/**
 * Combination #5 — OOP OBJECT FLOW × XPATH INJECTION (CWE-643). Constructor-injected
 * taint stored in a field, concatenated into an XPath query. NO finding = FALSE NEGATIVE.
 */
public class OopFlowXPath {

    private final String name;

    public OopFlowXPath(HttpServletRequest req) {
        this.name = req.getParameter("name");
    }

    public String getName() {
        return this.name;
    }

    public String findDirect(Document doc) throws Exception {
        XPath xp = XPathFactory.newInstance().newXPath();
        return xp.evaluate("//user[name='" + this.name + "']", doc);   // CWE-643
    }

    public String findViaGetter(Document doc) throws Exception {
        XPath xp = XPathFactory.newInstance().newXPath();
        return xp.evaluate("//user[name='" + getName() + "']", doc);   // CWE-643
    }
}
