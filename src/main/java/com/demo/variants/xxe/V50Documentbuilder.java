package com.demo.variants.xxe;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.servlet.http.HttpServletRequest;
public class V50Documentbuilder {
    public void parse(HttpServletRequest req) throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance(); // no FEATURE_SECURE_PROCESSING
        f.newDocumentBuilder().parse(req.getInputStream()); // SINK CWE-611 DocumentBuilder
    }
}
