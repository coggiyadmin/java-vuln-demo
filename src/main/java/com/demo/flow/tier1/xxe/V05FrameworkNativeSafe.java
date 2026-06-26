package com.demo.flow.tier1.xxe;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.servlet.http.HttpServletRequest;
public class V05FrameworkNativeSafe {
    public void parse(HttpServletRequest req) throws Exception {
        var factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.newDocumentBuilder().parse(req.getInputStream());
    }
}
