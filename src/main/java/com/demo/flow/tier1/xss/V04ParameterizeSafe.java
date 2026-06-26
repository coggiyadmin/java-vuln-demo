package com.demo.flow.tier1.xss;
import java.io.*; import javax.servlet.http.*;
public class V04ParameterizeSafe {
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().print("<h1>" + java.net.URLEncoder.encode(req.getParameter("q"), "UTF-8") + "</h1>");
    }
}
