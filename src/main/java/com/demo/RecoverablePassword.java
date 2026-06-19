package com.demo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

/** CWE-257 — Storing Passwords in a Recoverable Format. AES-encrypted (reversible) with a
 * key on hand, so the password can be decrypted. (Engine gap.) FN probe. */
public class RecoverablePassword {
    private static final byte[] KEY = "0123456789abcdef".getBytes();

    public byte[] store(HttpServletRequest req) throws Exception {
        String password = req.getParameter("password");   // SOURCE
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY, "AES"));
        return c.doFinal(password.getBytes());   // reversible → CWE-257
    }
}
