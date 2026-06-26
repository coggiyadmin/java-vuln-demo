package com.demo.flow.tier1.code_injection;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
public class V04ParameterizeSafe {
    private static final Map<String, Integer> LOOKUP = Map.of("0", 0, "1", 1);
    public int run(HttpServletRequest req) {
        return LOOKUP.getOrDefault(req.getParameter("x"), 0);
    }
}
