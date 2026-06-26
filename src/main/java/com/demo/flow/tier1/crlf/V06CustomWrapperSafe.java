package com.demo.flow.tier1.crlf;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("\r", "").replace("\n", ""); }
    public void redir(HttpServletRequest req, HttpServletResponse res) {
        res.setHeader("Location", companySanitize(req.getParameter("url")));
    }
}
