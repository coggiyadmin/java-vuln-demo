package com.demo;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import javax.servlet.http.*;

/**
 * CATEGORY-COVERAGE probes — insecure crypto *configuration* and other classes
 * not modeled by the taint-sink-based weak_crypto rule (which keys on the
 * algorithm string reaching a sink). These are constant-config vulnerabilities.
 */
public class CryptoConfig {

    // CWE-321 — hardcoded symmetric key
    private static final byte[] KEY = "1234567890123456".getBytes();
    // CWE-329 — static/zero IV reused across messages
    private static final byte[] IV = new byte[16];

    // CWE-327 — ECB mode (deterministic; leaks plaintext patterns)
    public byte[] ecb(String pt) throws Exception {
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY, "AES"));
        return c.doFinal(pt.getBytes());
    }

    // CWE-329 — CBC with a static IV + hardcoded key
    public byte[] staticIv(String pt) throws Exception {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY, "AES"), new IvParameterSpec(IV));
        return c.doFinal(pt.getBytes());
    }

    // CWE-326 — 512-bit RSA (far below 2048 minimum)
    public KeyPair weakRsa() throws Exception {
        KeyPairGenerator g = KeyPairGenerator.getInstance("RSA");
        g.initialize(512);
        return g.generateKeyPair();
    }

    // CWE-134 — format string with user-controlled format specifier
    public String fmt(HttpServletRequest req) {
        String f = req.getParameter("fmt");
        return String.format(f, "data");   // %n / argument-index attacks
    }

    // CWE-113 — CRLF / response splitting via user input in a header
    public void header(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("X-Track", req.getParameter("v"));  // CR/LF splits response
    }

    // CWE-532 — password written to log in cleartext
    public void audit(HttpServletRequest req) {
        String pw = req.getParameter("password");
        System.getLogger("audit").log(System.Logger.Level.INFO, "pwd=" + pw);
    }
}
