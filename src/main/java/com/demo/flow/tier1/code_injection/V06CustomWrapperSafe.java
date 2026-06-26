package com.demo.flow.tier1.code_injection;
import javax.servlet.http.HttpServletRequest;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("__", "").replace(";", ""); }
    public String run(HttpServletRequest req) {
        return companySanitize(req.getParameter("x"));
    }
}
