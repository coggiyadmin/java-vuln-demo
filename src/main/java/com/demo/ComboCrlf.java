package com.demo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/** CRLF combination probes (CWE-113) — FN until rule #86. */
public class ComboCrlf {
    public void wrong(HttpServletRequest req, HttpServletResponse res) {
        res.setHeader("Location", req.getParameter("url").replace("<", "")); // CWE-113
    }
}
