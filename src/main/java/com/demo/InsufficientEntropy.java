package com.demo;

import java.util.Random;

/** CWE-331 — Insufficient Entropy. A security token from non-crypto java.util.Random. NO finding = FN. */
public class InsufficientEntropy {
    public String resetToken() {
        return String.format("%06d", new Random().nextInt(1_000_000));   // not a CSPRNG → CWE-331/338
    }
}
