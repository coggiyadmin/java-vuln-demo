package com.demo.config.weak_crypto;

import javax.crypto.Cipher;
public class V01EcbModeTp {
    public Cipher cipher() throws Exception {
        return Cipher.getInstance("AES/ECB/PKCS5Padding"); // SINK CWE-327
    }
}
