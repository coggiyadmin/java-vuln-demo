package com.demo.variants.xxe;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.servlet.http.HttpServletRequest;
public class V01ParseString {
    public void parse(HttpServletRequest req) throws Exception {
        var db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        db.parse(req.getInputStream()); // SINK CWE-611
    }
}
