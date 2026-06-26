package com.demo.flow.tier1.code_injection;
import javax.servlet.http.HttpServletRequest;
public class V07HardeningSafe {
    public String run(HttpServletRequest req) {
        String x = req.getParameter("x");
        return switch (x) { case "0", "1", "2" -> x; default -> throw new SecurityException(); };
    }
}
