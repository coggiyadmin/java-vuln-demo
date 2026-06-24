// FP-target (cognium-dev#116) — AES/GCM is authenticated encryption; must not be flagged weak-crypto.
package com.demo.fpcorpus;
import javax.crypto.Cipher;
public class SafeAesGcm {
    public Cipher cipher() throws Exception { return Cipher.getInstance("AES/GCM/NoPadding"); } // safe mode
}
