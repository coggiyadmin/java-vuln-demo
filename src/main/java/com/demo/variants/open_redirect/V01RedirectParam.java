package com.demo.variants.open_redirect;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
public class V01RedirectParam {
    public void go(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect(req.getParameter("next")); // SINK CWE-601
    }
}
