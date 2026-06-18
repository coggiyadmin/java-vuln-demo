package com.demo.xf;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;

public class XfDeserializeHelper {
    public static Object run(String blob) throws Exception {
        byte[] b = Base64.getDecoder().decode(blob);
        return new ObjectInputStream(new ByteArrayInputStream(b)).readObject(); // SINK CWE-502
    }
}
