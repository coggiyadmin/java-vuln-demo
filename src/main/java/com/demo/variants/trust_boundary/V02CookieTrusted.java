package com.demo.variants.trust_boundary;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V02CookieTrusted {
    public void admin(HttpServletRequest req, HttpServletResponse res) {
        String flag = req.getParameter("admin");
        res.addCookie(new Cookie("is_admin", flag)); // SINK CWE-501
    }
}
