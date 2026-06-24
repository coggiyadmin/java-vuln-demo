package com.demo.config.xml_entity_expansion;

import javax.xml.parsers.DocumentBuilderFactory;
public class V01ResolveEntitiesSafe {
    public void parse(java.io.InputStream in) throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        f.newDocumentBuilder().parse(in);
    }
}
