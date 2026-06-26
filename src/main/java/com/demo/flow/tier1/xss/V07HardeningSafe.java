package com.demo.flow.tier1.xss;
import java.io.*; import javax.servlet.http.*;
public class V07HardeningSafe {
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String q = req.getParameter("q");
        if (q.length() > 32) throw new SecurityException();
        res.getWriter().print("<h1>" + org.owasp.encoder.Encode.forHtml(q) + "</h1>");
    }
}
