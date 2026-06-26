package com.demo.taint.sanitize.kinds;
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class SK07_ssrf {
  public void parseXml(byte[] raw) throws Exception {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    dbf.newDocumentBuilder().parse(new ByteArrayInputStream(raw)); // SK-07 XXE hardening TN
  }
}
