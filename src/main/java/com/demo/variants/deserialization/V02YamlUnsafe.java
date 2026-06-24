package com.demo.variants.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
public class V02YamlUnsafe {
    public Object json(HttpServletRequest req) throws Exception {
        return new ObjectMapper().readValue(req.getParameter("j"), Object.class); // SINK CWE-502
    }
}
