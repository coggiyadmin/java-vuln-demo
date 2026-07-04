package com.demo.variants.xxe;

import javax.xml.stream.XMLInputFactory;
import javax.servlet.http.HttpServletRequest;
public class V51StaxReader {
    public void stax(HttpServletRequest req) throws Exception {
        XMLInputFactory f = XMLInputFactory.newInstance(); // IS_SUPPORTING_EXTERNAL_ENTITIES default
        f.createXMLStreamReader(req.getInputStream()); // SINK CWE-611 StAX
    }
}
