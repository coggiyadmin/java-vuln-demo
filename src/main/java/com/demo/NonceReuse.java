package com.demo;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/** CWE-323 — Reusing a Nonce in Encryption. A fixed AES-GCM nonce is reused across
 * encryptions. Real vuln; NO finding = FALSE NEGATIVE. */
public class NonceReuse {
    private static final byte[] KEY = "0123456789abcdef".getBytes();
    private static final byte[] NONCE = new byte[12];   // static nonce, reused → CWE-323

    public byte[] enc(String data) throws Exception {
        Cipher c = Cipher.getInstance("AES/GCM/NoPadding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY, "AES"), new GCMParameterSpec(128, NONCE)); // reused nonce → CWE-323
        return c.doFinal(data.getBytes());
    }
}
