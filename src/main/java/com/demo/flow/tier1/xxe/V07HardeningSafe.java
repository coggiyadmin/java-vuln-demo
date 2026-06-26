package com.demo.flow.tier1.xxe;
import javax.xml.parsers.*;
import javax.servlet.http.*;
public class V07HardeningSafe {
    public void parse(HttpServletRequest req) throws Exception {
        if (req.getContentLengthLong() > 65536) throw new SecurityException();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        dbf.newDocumentBuilder().parse(req.getInputStream());
    }
}
