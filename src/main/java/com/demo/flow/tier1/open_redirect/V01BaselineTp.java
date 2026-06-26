package com.demo.flow.tier1.open_redirect;

import javax.servlet.http.*;
public class V01BaselineTp {
    public void go(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect(req.getParameter("next")); // SINK CWE-601
    }
}
