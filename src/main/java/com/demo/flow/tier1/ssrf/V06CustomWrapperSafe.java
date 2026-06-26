package com.demo.flow.tier1.ssrf;
import java.net.*; import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String u) { return u.replace("@", ""); }
    public void fetch(HttpServletRequest req) throws Exception {
        String u = companySanitize(req.getParameter("url"));
        if (u.contains("169.254")) throw new SecurityException();
        new URL(u).openStream();
    }
}
