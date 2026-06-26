package com.demo.flow.tier1.code_injection;
import javax.servlet.http.HttpServletRequest;
public class V03EncodeSafe {
    public String run(HttpServletRequest req) {
        return req.getParameter("x").replaceAll("[;{}]", "");
    }
}
