package com.demo.flow.tier1.crlf;

import javax.servlet.http.*;
public class V01BaselineTp {
    public void redir(HttpServletRequest req, HttpServletResponse res) {
        res.setHeader("Location", req.getParameter("url")); // SINK CWE-93
    }
}
