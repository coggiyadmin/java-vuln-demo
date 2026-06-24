package com.demo.variants.deserialization;

import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;
import javax.servlet.http.HttpServletRequest;
public class V01NativeUnsafe {
    public Object read(HttpServletRequest req) throws Exception {
        byte[] b = req.getParameter("s").getBytes();
        return new ObjectInputStream(new ByteArrayInputStream(b)).readObject(); // SINK CWE-502
    }
}
