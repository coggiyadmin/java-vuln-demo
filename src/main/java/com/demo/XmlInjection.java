package com.demo;

import javax.servlet.http.HttpServletRequest;

/** CWE-91 — XML Injection. Unescaped input concatenated into an XML document injects
 * structure (e.g. override price). Real vuln; NO finding = FALSE NEGATIVE. */
public class XmlInjection {
    public String build(HttpServletRequest req) {
        String qty = req.getParameter("qty");   // SOURCE
        // qty = "1</qty><price>0</price><qty>1" injects elements → CWE-91
        return "<order><qty>" + qty + "</qty><price>100</price></order>";
    }
}
