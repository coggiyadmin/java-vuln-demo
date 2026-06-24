package com.demo.config.xml_entity_expansion;

import javax.xml.parsers.DocumentBuilderFactory;
public class V01ResolveEntitiesTp {
    public void parse(java.io.InputStream in) throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setExpandEntityReferences(true); // SINK CWE-776
        f.newDocumentBuilder().parse(in);
    }
}
