package com.demo.flow.tier1.code_injection;

import javax.servlet.http.*;
public class V07HardeningSafe {
    public String run(HttpServletRequest req) {
        String x = req.getParameter("x");
        return switch (x) { case "daily" -> "ok"; case "weekly" -> "ok"; default -> throw new SecurityException(); };
    }
}
