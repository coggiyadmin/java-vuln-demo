package com.demo;

import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

/** CWE-261 — Weak Encoding for Password. base64 (encoding, not encryption) used as if it
 * protected the password. (Engine gap.) FN probe. */
public class WeakPasswordEncoding {
    public String store(HttpServletRequest req) {
        String password = req.getParameter("password");   // SOURCE
        return Base64.getEncoder().encodeToString(password.getBytes()); // encoding ≠ protection → CWE-261
    }
}
