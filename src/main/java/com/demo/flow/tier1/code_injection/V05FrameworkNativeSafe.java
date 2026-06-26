package com.demo.flow.tier1.code_injection;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
public class V05FrameworkNativeSafe {
    private static final Map<String, Integer> LOOKUP = Map.of("0", 0, "1", 1, "2", 2);
    public int run(HttpServletRequest req) {
        return LOOKUP.getOrDefault(req.getParameter("x"), 0);
    }
}
