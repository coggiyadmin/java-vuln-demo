package com.demo.config.weak_crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class V11DesCipherTp {
    public byte[] enc(byte[] key, byte[] data) throws Exception {
        Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding"); // SINK CWE-327 DES
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "DES"));
        return c.doFinal(data);
    }
}
