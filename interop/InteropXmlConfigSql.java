package com.demo.interop;
import java.sql.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.ByteArrayInputStream;

/** IL-51 — XML config value → SQL string (IL-5 frontier). */
public class InteropXmlConfigSql {
    public void lookup(byte[] raw) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            .parse(new ByteArrayInputStream(raw));
        String filt = doc.getDocumentElement().getElementsByTagName("name").item(0).getTextContent();
        Statement s = DriverManager.getConnection("jdbc:sqlite::memory:").createStatement();
        s.executeQuery("SELECT * FROM u WHERE n='" + filt + "'");
    }
}
