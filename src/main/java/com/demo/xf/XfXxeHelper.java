package com.demo.xf;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XfXxeHelper {
    public static Document run(String xml) throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        return f.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes())); // SINK CWE-611
    }
}
