package com.demo.flow.tier1.xxe;
import javax.xml.parsers.*;
import javax.servlet.http.*;
import java.io.*;
public class V05FrameworkNativeSafe {
    public void parse(HttpServletRequest req) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        dbf.newDocumentBuilder().parse(req.getInputStream());
    }
}
