package com.demo.flow.tier1.deserialization;
import com.fasterxml.jackson.databind.*;
import javax.servlet.http.*;
public class V05FrameworkNativeSafe {
    public Object load(HttpServletRequest req) throws Exception {
        return new ObjectMapper().readValue(req.getInputStream(), Object.class);
    }
}
