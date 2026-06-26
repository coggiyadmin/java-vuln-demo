package com.demo.flow.tier1.ssrf;
import java.net.*; import javax.servlet.http.*;
public class V03EncodeSafe {
    public void fetch(HttpServletRequest req) throws Exception {
        String u = req.getParameter("url").replace("169.254.", "");
        new URL(u).openStream();
    }
}
