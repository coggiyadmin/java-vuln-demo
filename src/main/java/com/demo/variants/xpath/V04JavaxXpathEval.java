package com.demo.variants.xpath;

import javax.xml.xpath.XPathFactory;
import javax.servlet.http.HttpServletRequest;
public class V04JavaxXpathEval {
    public void javaxXPath(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name"); // SOURCE
        XPathFactory.newInstance().newXPath().evaluate("//user[@name='" + name + "']", null); // SINK CWE-643
    }
}
