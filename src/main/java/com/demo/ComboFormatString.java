package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Format-string combination probes (CWE-134) — FN until rule #86. */
public class ComboFormatString {
    public String wrong(HttpServletRequest req) {
        String fmt = req.getParameter("fmt").replace("<", "");
        return String.format(fmt, "guest"); // CWE-134
    }
}
