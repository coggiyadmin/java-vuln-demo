package com.demo.variants.crlf;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V03SetCookieLib {
    public void cookie(HttpServletRequest req, HttpServletResponse res) {
        res.addCookie(new Cookie("session", req.getParameter("val"))); // SINK CWE-93
    }
}
