package com.demo;

import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — XmlInjection; value XML-escaped before insertion. Expect 0 findings. */
public class SafeXmlInjection {
    public String build(HttpServletRequest req) {
        String qty = req.getParameter("qty")
                .replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");  // escaped
        return "<order><qty>" + qty + "</qty><price>100</price></order>";
    }
}
