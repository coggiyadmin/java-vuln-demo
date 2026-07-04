package com.demo.variants.deserialization;

import java.io.*;
import javax.servlet.http.HttpServletRequest;
public class V05PickleLoads {
    public void pickle(HttpServletRequest req) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(req.getInputStream()); // SINK CWE-502
        ois.readObject();
    }
}
