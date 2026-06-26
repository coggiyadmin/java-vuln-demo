package com.demo.flow.tier1.format_string;
import javax.servlet.http.*;
public class V05FrameworkNativeSafe {
    public void greet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.getWriter().printf("Hello %s", req.getParameter("name"));
    }
}
