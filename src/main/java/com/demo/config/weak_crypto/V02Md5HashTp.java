package com.demo.config.weak_crypto;

import java.security.MessageDigest;
public class V02Md5HashTp {
    public byte[] hash(String s) throws Exception {
        return MessageDigest.getInstance("MD5").digest(s.getBytes()); // SINK CWE-328
    }
}
