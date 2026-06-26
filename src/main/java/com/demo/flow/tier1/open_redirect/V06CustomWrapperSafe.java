package com.demo.flow.tier1.open_redirect;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("//evil", ""); }
    public void go(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect(companySanitize(req.getParameter("next")));
    }
}
