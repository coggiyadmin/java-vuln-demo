package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #11 — FAN-OUT × deserialize. */
public class FanoutDeserialize {

    public void fanout(HttpServletRequest req) throws Exception {
        String s = req.getParameter("s");
        new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(java.util.Base64.getDecoder().decode(s))).readObject(); // CWE-502
        new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(java.util.Base64.getDecoder().decode(s + ""))).readObject(); // CWE-502
        new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(s.getBytes())).readObject(); // CWE-502
    }
}
