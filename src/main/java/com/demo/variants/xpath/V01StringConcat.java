package com.demo.variants.xpath;

import javax.xml.xpath.XPath;
import org.xml.sax.InputSource;
import javax.servlet.http.HttpServletRequest;
public class V01StringConcat {
    public void eval(HttpServletRequest req, XPath xp) throws Exception {
        String name = req.getParameter("name");
        xp.evaluate("//user[name='" + name + "']", new InputSource()); // SINK CWE-643
    }
}
