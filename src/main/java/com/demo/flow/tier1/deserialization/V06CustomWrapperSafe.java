package com.demo.flow.tier1.deserialization;
import com.fasterxml.jackson.databind.*;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("__", ""); }
    public Object load(HttpServletRequest req) throws Exception {
        String raw = companySanitize(new String(req.getInputStream().readAllBytes()));
        return new ObjectMapper().readValue(raw, Object.class);
    }
}
