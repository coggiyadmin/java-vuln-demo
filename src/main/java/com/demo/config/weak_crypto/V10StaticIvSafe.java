package com.demo.config.weak_crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
public class V10StaticIvSafe {
    public byte[] enc(byte[] key, byte[] data) throws Exception {
        byte[] ivb = new byte[16]; new SecureRandom().nextBytes(ivb);
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(ivb));
        return c.doFinal(data);
    }
}
