package com.demo.variants.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
public class V12JacksonReadvalue {
    public void jackson(HttpServletRequest req) throws Exception {
        byte[] blob = req.getInputStream().readAllBytes(); // SOURCE
        new ObjectMapper().readValue(blob, Object.class); // SINK CWE-502 Jackson
    }
}
