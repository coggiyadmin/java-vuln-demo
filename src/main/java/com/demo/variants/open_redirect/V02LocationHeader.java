package com.demo.variants.open_redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class V02LocationHeader {
    public void loc(HttpServletRequest req, HttpServletResponse res) {
        res.setHeader("Location", req.getParameter("url")); // SINK CWE-601
        res.setStatus(302);
    }
}
