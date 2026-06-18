package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathVariableResolver;
import org.w3c.dom.Document;

/** SAFE mirror — OopFlowXPath; value bound as an XPath variable, not concatenated. */
public class SafeOopFlowXPath {

    private final String name;

    public SafeOopFlowXPath(HttpServletRequest req) {
        this.name = req.getParameter("name");
    }

    public String findDirect(Document doc) throws Exception {
        XPath xp = XPathFactory.newInstance().newXPath();
        xp.setXPathVariableResolver(new XPathVariableResolver() {
            public Object resolveVariable(QName v) { return name; }   // value passed as $n
        });
        return xp.evaluate("//user[name=$n]", doc);
    }
}
