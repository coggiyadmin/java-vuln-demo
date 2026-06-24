package com.demo.variants.crlf;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
public class V01LocationHeader {
    public void redir(HttpServletRequest req, HttpServletResponse res) {
        res.setHeader("Location", req.getParameter("url")); // SINK CWE-93
    }
}
