// TP (CWE-327) — AES/ECB is a genuinely weak mode and must fire.
package com.demo.fpcorpus;
import javax.crypto.Cipher;
public class EcbCipherTp {
    public Cipher cipher() throws Exception { return Cipher.getInstance("AES/ECB/PKCS5Padding"); } // SINK (CWE-327)
}
