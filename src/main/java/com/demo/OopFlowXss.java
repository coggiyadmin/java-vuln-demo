package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #5 — OOP × XSS (CWE-79). NO finding = FN (#78). */
public class OopFlowXss {
    static class Page {
        String title;
        Page(String t) { this.title = t; }
        String render() { return "<h1>" + this.title + "</h1>"; } // CWE-79
    }
    public String page(HttpServletRequest req) {
        Page p = new Page(req.getParameter("q"));
        return p.render();
    }
}
