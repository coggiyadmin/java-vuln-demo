package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #13 — ENCODED PAYLOAD × deserialize. */
public class EncodedDeserialize {

    public void b64(HttpServletRequest req) throws Exception {
        String s = new String(java.util.Base64.getDecoder().decode(req.getParameter("d")));
        new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(s.getBytes())).readObject(); // CWE-502
    }
    public void url(HttpServletRequest req) throws Exception {
        String s = java.net.URLDecoder.decode(req.getParameter("d"), "UTF-8");
        new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(s.getBytes())).readObject(); // CWE-502
    }
}
