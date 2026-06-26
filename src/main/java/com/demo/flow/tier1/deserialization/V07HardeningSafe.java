package com.demo.flow.tier1.deserialization;
import com.fasterxml.jackson.databind.*;
import javax.servlet.http.*;
public class V07HardeningSafe {
    public Object load(HttpServletRequest req) throws Exception {
        if (req.getContentLengthLong() > 65536) throw new SecurityException();
        return new ObjectMapper().readValue(req.getInputStream(), Object.class);
    }
}
