package com.demo.config.weak_crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class V10StaticIvTp {
    public byte[] enc(byte[] key, byte[] data) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(new byte[16]); // SINK CWE-329 static all-zero IV
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), iv);
        return c.doFinal(data);
    }
}
