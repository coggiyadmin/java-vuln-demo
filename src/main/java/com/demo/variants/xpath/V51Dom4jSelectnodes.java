package com.demo.variants.xpath;

import org.dom4j.io.SAXReader;
import org.dom4j.Document;
import javax.servlet.http.HttpServletRequest;
public class V51Dom4jSelectnodes {
    public void select(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name"); // SOURCE
        Document doc = new SAXReader().read("users.xml");
        doc.selectNodes("//user[@name='" + name + "']"); // SINK CWE-643 dom4j selectNodes
    }
}
