package com.demo.variants.xpath;

import javax.xml.xpath.XPathFactory;
import javax.servlet.http.HttpServletRequest;
public class V02EvaluateExpr {
    public String evaluate(HttpServletRequest req) throws Exception {
        String expr = req.getParameter("expr");
        return XPathFactory.newInstance().newXPath().evaluate(expr, new org.xml.sax.InputSource()); // SINK CWE-643
    }
}
