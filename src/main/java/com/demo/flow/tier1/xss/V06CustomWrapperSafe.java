package com.demo.flow.tier1.xss;
import java.io.*; import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String v) { return v.replace("<", "").replace(">", ""); }
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().print("<h1>" + companySanitize(req.getParameter("q")) + "</h1>");
    }
}
