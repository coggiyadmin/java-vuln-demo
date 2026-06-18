package com.demo;

import java.io.ByteArrayInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 * Combination #5 — OOP OBJECT FLOW × XXE (CWE-611). Constructor-injected taint parsed
 * by a DocumentBuilder with external entities NOT disabled. NO finding = FALSE NEGATIVE.
 */
public class OopFlowXxe {

    private final String xml;

    public OopFlowXxe(HttpServletRequest req) {
        this.xml = req.getParameter("xml");
    }

    public String getXml() {
        return this.xml;
    }

    public Document parseDirect() throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();   // entities not disabled
        return f.newDocumentBuilder().parse(new ByteArrayInputStream(this.xml.getBytes()));   // CWE-611
    }

    public Document parseViaGetter() throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        return f.newDocumentBuilder().parse(new ByteArrayInputStream(getXml().getBytes()));   // CWE-611
    }
}
