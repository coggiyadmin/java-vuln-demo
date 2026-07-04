package com.demo.variants.deserialization;

import java.beans.XMLDecoder;
import javax.servlet.http.HttpServletRequest;
public class V50Xmldecoder {
    public Object decode(HttpServletRequest req) throws Exception {
        byte[] blob = req.getInputStream().readAllBytes(); // SOURCE
        return new XMLDecoder(new java.io.ByteArrayInputStream(blob)).readObject(); // SINK CWE-502 XMLDecoder
    }
}
