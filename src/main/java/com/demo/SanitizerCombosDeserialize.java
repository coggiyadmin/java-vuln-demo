package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combinations #6/#7/#8 — SANITIZER × DESERIALIZATION (CWE-502). */
public class SanitizerCombosDeserialize {

    private static String escapeHtml(String s) { return s.replace("<", "_"); }
    private static String sanitize(String s) { return s; }
    public void wrong(HttpServletRequest req) throws Exception {
        new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(java.util.Base64.getDecoder().decode(escapeHtml(req.getParameter("s"))))).readObject(); // CWE-502
    }

    public void fake(HttpServletRequest req) throws Exception {
        new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(java.util.Base64.getDecoder().decode(sanitize(req.getParameter("s"))))).readObject(); // CWE-502
    }

    public void wrapped(HttpServletRequest req) throws Exception {
        new com.google.gson.Gson().fromJson(new String(java.util.Base64.getDecoder().decode(req.getParameter("s"))), Object.class); // expect 0 — json not Java deser
    }
}
