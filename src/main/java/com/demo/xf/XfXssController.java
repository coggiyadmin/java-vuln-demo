package com.demo.xf;

import javax.servlet.http.HttpServletRequest;

/** Combination #1 — CROSS-FILE × XSS (CWE-79). */
public class XfXssController {
    public String handle(HttpServletRequest req) {
        String q = req.getParameter("q"); // SOURCE
        return XfXssHelper.renderTitle(q); // cross-file sink
    }
}
