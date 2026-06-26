package com.demo.flow.tier1.crlf;

import javax.servlet.http.*;
public class V07HardeningSafe {
    public void redir(HttpServletRequest req, HttpServletResponse res) {
        String loc = req.getParameter("url");
        if (loc != null && (loc.contains("\r") || loc.contains("\n"))) {
            throw new SecurityException("forbidden");
        }
        res.setHeader("Location", loc);
    }
}
