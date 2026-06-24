package com.demo.config.insecure_cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
public class V01NoFlagsTp {
    public void set(HttpServletResponse resp, String sid) {
        Cookie c = new Cookie("SESSIONID", sid);
        c.setSecure(false); c.setHttpOnly(false); // SINK CWE-614
        resp.addCookie(c);
    }
}
