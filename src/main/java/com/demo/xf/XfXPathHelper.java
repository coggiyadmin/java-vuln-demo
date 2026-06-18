package com.demo.xf;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

public class XfXPathHelper {
    public static String run(Document doc, String name) throws Exception {
        XPath xp = XPathFactory.newInstance().newXPath();
        return xp.evaluate("//user[name='" + name + "']", doc); // SINK CWE-643
    }
}
