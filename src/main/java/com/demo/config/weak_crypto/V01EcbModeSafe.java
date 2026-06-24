package com.demo.config.weak_crypto;

import javax.crypto.Cipher;
public class V01EcbModeSafe {
    public Cipher cipher() throws Exception {
        return Cipher.getInstance("AES/GCM/NoPadding"); // SAFE — AEAD
    }
}
