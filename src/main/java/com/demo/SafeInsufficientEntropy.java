package com.demo;

import java.security.SecureRandom;

/** SAFE mirror — InsufficientEntropy; uses SecureRandom (CSPRNG). Expect 0 findings. */
public class SafeInsufficientEntropy {
    private static final SecureRandom RNG = new SecureRandom();

    public String resetToken() {
        byte[] b = new byte[16];
        RNG.nextBytes(b);
        return java.util.HexFormat.of().formatHex(b);
    }
}
