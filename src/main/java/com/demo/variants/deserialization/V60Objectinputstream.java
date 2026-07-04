package com.demo.variants.deserialization;

import java.io.ObjectInputStream;
import javax.servlet.http.HttpServletRequest;
public class V60Objectinputstream {
    public Object read(HttpServletRequest req) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(req.getInputStream()); // SOURCE
        return ois.readObject(); // SINK CWE-502 native Java deserialization
    }
}
