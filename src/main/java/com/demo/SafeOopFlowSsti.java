package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — OopFlowSsti; the user value is treated as plain data and never parsed
 * as an expression/template. Expect 0 security findings.
 */
public class SafeOopFlowSsti {

    private final String name;

    public SafeOopFlowSsti(HttpServletRequest req) {
        this.name = req.getParameter("name");
    }

    public String renderDirect() {
        return "<p>Hello " + escape(this.name) + "</p>";   // data, no expression evaluation
    }

    private static String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
