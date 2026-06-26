package com.demo.flow.tier1.xxe;
import javax.xml.parsers.*;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("<!ENTITY", ""); }
    public void parse(HttpServletRequest req) throws Exception {
        String raw = companySanitize(new String(req.getInputStream().readAllBytes()));
        DocumentBuilderFactory.newInstance().newDocumentBuilder()
          .parse(new java.io.ByteArrayInputStream(raw.getBytes()));
    }
}
