package com.demo;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/** CWE-1204 — Weak/Static Initialization Vector. A static IV is used for AES-CBC. NO finding = FN. */
public class StaticIv {
    private static final byte[] KEY = "0123456789abcdef".getBytes();
    private static final byte[] IV = new byte[16];   // static all-zero IV → CWE-1204

    public byte[] enc(String data) throws Exception {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY, "AES"), new IvParameterSpec(IV)); // static IV → CWE-1204
        return c.doFinal(data.getBytes());
    }
}
