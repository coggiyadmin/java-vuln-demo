package com.demo.variants.xxe;

import javax.xml.parsers.SAXParserFactory;
import javax.servlet.http.HttpServletRequest;
public class V03LibxmlSaxLib {
    public void sax(HttpServletRequest req) throws Exception {
        SAXParserFactory.newInstance().newSAXParser().parse(
            new java.io.ByteArrayInputStream(req.getParameter("xml").getBytes()), null); // SINK CWE-611 SAX
    }
}
