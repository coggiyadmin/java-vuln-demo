package com.demo.variants.xxe;

import javax.xml.parsers.SAXParserFactory;
import javax.servlet.http.HttpServletRequest;
public class V02SaxParser {
    public void sax(HttpServletRequest req) throws Exception {
        SAXParserFactory.newInstance().newSAXParser().parse(req.getInputStream(), null); // SINK CWE-611
    }
}
