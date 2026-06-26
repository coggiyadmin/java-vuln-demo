package com.demo.flow.tier1.ssrf;
import java.net.*; import javax.servlet.http.*;
public class V04ParameterizeSafe {
    public void fetch(HttpServletRequest req) throws Exception {
        new URL("https://api.internal.example.com/" + req.getParameter("path")).openStream();
    }
}
