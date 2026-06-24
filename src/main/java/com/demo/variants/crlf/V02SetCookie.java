package com.demo.variants.crlf;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
public class V02SetCookie {
    public void track(HttpServletRequest req, HttpServletResponse res) {
        res.addCookie(new Cookie("track", req.getParameter("v"))); // SINK CWE-93
    }
}
