package com.demo.variants.open_redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V50ServletSendredirect {
    public void go(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getParameter("url"); // SOURCE
        resp.sendRedirect(url); // SINK CWE-601 servlet sendRedirect
    }
}
