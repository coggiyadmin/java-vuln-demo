package com.demo.variants.crlf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V50ServletAddheader {
    public void header(HttpServletRequest req, HttpServletResponse resp) {
        String lang = req.getParameter("lang"); // SOURCE
        resp.addHeader("Content-Language", lang); // SINK CWE-113 servlet addHeader
    }
}
