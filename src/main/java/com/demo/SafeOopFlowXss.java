package com.demo;

import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — OopFlowXss. Expect 0. */
public class SafeOopFlowXss {
    static class Page {
        String title;
        Page(String t) { this.title = t; }
        String render() {
            return "<h1>" + org.apache.commons.text.StringEscapeUtils.escapeHtml4(this.title) + "</h1>";
        }
    }
    public String page(HttpServletRequest req) {
        Page p = new Page(req.getParameter("q"));
        return p.render();
    }
}
