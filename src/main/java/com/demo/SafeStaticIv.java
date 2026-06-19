package com.demo;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/** SAFE mirror — StaticIv; a fresh random IV is generated per encryption. Expect 0 findings. */
public class SafeStaticIv {
    private static final byte[] KEY = "0123456789abcdef".getBytes();
    private static final SecureRandom RNG = new SecureRandom();

    public byte[] enc(String data) throws Exception {
        byte[] iv = new byte[16];
        RNG.nextBytes(iv);                       // unique IV per encryption
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY, "AES"), new IvParameterSpec(iv));
        return c.doFinal(data.getBytes());
    }
}
