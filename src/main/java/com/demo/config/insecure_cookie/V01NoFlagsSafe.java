package com.demo.config.insecure_cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
public class V01NoFlagsSafe {
    public void set(HttpServletResponse resp, String sid) {
        Cookie c = new Cookie("SESSIONID", sid);
        c.setSecure(true); c.setHttpOnly(true);
        resp.addCookie(c);
    }
}
