// TP (CWE-328 / cognium-dev#119) — chained MessageDigest.getInstance("MD5").digest(...) must
// be flagged weak-hash even when getInstance + digest are chained on one line.
package com.demo.fpcorpus;
import java.security.MessageDigest;
public class WeakHashChained {
    public byte[] hash(byte[] data) throws Exception {
        return MessageDigest.getInstance("MD5").digest(data); // SINK (CWE-328, chained)
    }
}
