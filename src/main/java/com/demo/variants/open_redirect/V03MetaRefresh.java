package com.demo.variants.open_redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class V03MetaRefresh {
    public void meta(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String next = req.getParameter("next");
        res.setContentType("text/html");
        res.getWriter().write("<meta http-equiv=\"refresh\" content=\"0;url=" + next + "\">"); // CWE-601
    }
}
