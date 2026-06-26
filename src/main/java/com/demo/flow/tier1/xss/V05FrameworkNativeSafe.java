package com.demo.flow.tier1.xss;
import java.io.*; import javax.servlet.http.*;
public class V05FrameworkNativeSafe {
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String q = org.owasp.encoder.Encode.forHtml(req.getParameter("q"));
        res.getWriter().print("<h1>" + q + "</h1>");
    }
}
