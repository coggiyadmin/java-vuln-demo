package com.demo;

import java.util.Random;

/** CWE-335 — Incorrect Usage of Seeds in PRNG. The PRNG is seeded with the current time,
 * making output predictable. Real vuln; NO finding = FALSE NEGATIVE. */
public class PredictableSeed {
    public long sessionId() {
        Random r = new Random(System.currentTimeMillis());   // predictable seed → CWE-335
        return r.nextLong();
    }
}
