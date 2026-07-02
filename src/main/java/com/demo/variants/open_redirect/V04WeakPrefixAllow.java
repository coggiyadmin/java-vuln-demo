package com.demo.variants.open_redirect;

import javax.servlet.http.*;
public class V04WeakPrefixAllow {
    public void go(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String nxt = req.getParameter("next");
        if (nxt != null && nxt.startsWith("https://app.example.com"))
            resp.sendRedirect(nxt); // SINK CWE-601
    }
}
