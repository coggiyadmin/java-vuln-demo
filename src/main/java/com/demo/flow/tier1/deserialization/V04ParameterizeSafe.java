package com.demo.flow.tier1.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
public class V04ParameterizeSafe {
    public Object read(HttpServletRequest req) throws Exception {
        return new ObjectMapper().readValue(req.getParameter("j"), Object.class);
    }
}
