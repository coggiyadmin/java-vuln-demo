package com.demo.flow.tier1.xpath;

import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import javax.servlet.http.HttpServletRequest;
public class V01BaselineTp {
    public void eval(HttpServletRequest req, XPath xp) throws Exception {
        String name = req.getParameter("name"); // SOURCE
        xp.evaluate("//user[name='" + name + "']", new InputSource()); // SINK CWE-643
    }
}
