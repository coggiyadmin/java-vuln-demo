package com.demo.flow.tier1.xss;
import java.io.*; import javax.servlet.http.*;
public class V03EncodeSafe {
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String q = org.apache.commons.text.StringEscapeUtils.escapeHtml4(req.getParameter("q"));
        res.getWriter().print("<h1>" + q + "</h1>");
    }
}
