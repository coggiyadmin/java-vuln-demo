package com.demo.flow.tier1.ssrf;

import java.net.*;
import javax.servlet.http.*;
public class V01BaselineTp {
    public void fetch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String u = req.getParameter("url"); // SOURCE
        new URL(u).openStream(); // SINK CWE-918
        resp.sendRedirect(u);
    }
}
