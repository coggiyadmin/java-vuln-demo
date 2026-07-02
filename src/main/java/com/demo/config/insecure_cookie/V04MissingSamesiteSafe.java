package com.demo.config.insecure_cookie;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
public class V04MissingSamesiteSafe {
    public void set(HttpServletResponse resp, String sid) {
        Cookie c = new Cookie("SESSIONID", sid);
        c.setSecure(true); c.setHttpOnly(true); c.setAttribute("SameSite", "Lax");
        resp.addCookie(c);
    }
}
