package com.demo;

import java.io.ByteArrayInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 * SAFE mirror — OopFlowXxe; DOCTYPE declarations and external entities disabled on the
 * factory before parsing. Expect 0 security findings.
 */
public class SafeOopFlowXxe {

    private final String xml;

    public SafeOopFlowXxe(HttpServletRequest req) {
        this.xml = req.getParameter("xml");
    }

    public Document parseDirect() throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        f.setFeature("http://xml.org/sax/features/external-general-entities", false);
        f.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        f.setExpandEntityReferences(false);
        return f.newDocumentBuilder().parse(new ByteArrayInputStream(this.xml.getBytes()));
    }
}
