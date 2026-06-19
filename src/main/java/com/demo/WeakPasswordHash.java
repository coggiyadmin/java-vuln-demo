package com.demo;

import java.security.MessageDigest;
import javax.servlet.http.HttpServletRequest;

/** CWE-916 — Weak Password Hash. Fast, unsalted SHA-256 for passwords. NO finding = FN. */
public class WeakPasswordHash {
    public byte[] register(HttpServletRequest req) throws Exception {
        String password = req.getParameter("password");   // SOURCE
        return MessageDigest.getInstance("SHA-256").digest(password.getBytes());  // fast hash → CWE-916
    }
}
