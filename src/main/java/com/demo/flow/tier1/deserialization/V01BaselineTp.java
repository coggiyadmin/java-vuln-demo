package com.demo.flow.tier1.deserialization;

import java.io.*;
import javax.servlet.http.HttpServletRequest;
public class V01BaselineTp {
    public Object read(HttpServletRequest req) throws Exception {
        byte[] b = req.getParameter("s").getBytes(); // SOURCE
        return new ObjectInputStream(new ByteArrayInputStream(b)).readObject(); // SINK CWE-502
    }
}
