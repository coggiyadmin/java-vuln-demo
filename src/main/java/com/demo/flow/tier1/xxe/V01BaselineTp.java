package com.demo.flow.tier1.xxe;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.servlet.http.HttpServletRequest;
public class V01BaselineTp {
    public void parse(HttpServletRequest req) throws Exception {
        var db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        db.parse(req.getInputStream()); // SINK CWE-611
    }
}
