package com.demo.intake;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;

/** Safe mirror — JSON session restore only; no Java deserialization. */
public class MgmtIfaceDeserSafe {
    private final ObjectMapper mapper = new ObjectMapper();

    public java.util.Map<String, Object> restoreSession(HttpServletRequest req) throws Exception {
        return mapper.readValue(req.getInputStream(), java.util.Map.class);
    }
}
