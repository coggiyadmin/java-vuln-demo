package com.demo.config.weak_crypto;

import java.security.MessageDigest;
public class V02Md5HashSafe {
    public byte[] hash(String s) throws Exception {
        return MessageDigest.getInstance("SHA-256").digest(s.getBytes());
    }
}
