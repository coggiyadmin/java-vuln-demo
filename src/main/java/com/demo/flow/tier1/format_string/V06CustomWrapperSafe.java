package com.demo.flow.tier1.format_string;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("%", ""); }
    public void greet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.getWriter().print("Hello " + companySanitize(req.getParameter("name")));
    }
}
