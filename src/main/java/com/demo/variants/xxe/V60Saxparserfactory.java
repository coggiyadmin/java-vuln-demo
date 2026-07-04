package com.demo.variants.xxe;

import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import javax.servlet.http.HttpServletRequest;
public class V60Saxparserfactory {
    public void parse(HttpServletRequest req) throws Exception {
        SAXParserFactory f = SAXParserFactory.newInstance(); // external entities not disabled
        f.newSAXParser().parse(req.getInputStream(), new DefaultHandler()); // SINK CWE-611 SAXParser
    }
}
