package com.demo.variants.format_string;

import javax.servlet.http.HttpServletRequest;
public class V50StringFormatJava {
    public String fmt(HttpServletRequest req) {
        String f = req.getParameter("f"); // SOURCE
        return String.format(f, "arg"); // SINK CWE-134 user controls format
    }
}
