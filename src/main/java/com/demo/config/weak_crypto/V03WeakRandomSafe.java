package com.demo.config.weak_crypto;

import java.security.SecureRandom;
public class V03WeakRandomSafe {
    public byte[] token() { byte[] b = new byte[16]; new SecureRandom().nextBytes(b); return b; }
}
