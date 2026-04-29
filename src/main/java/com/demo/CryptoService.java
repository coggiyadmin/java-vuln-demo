package com.demo;

import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * DEMO FILE — intentional vulnerabilities for security scanner showcase.
 *
 * CWE findings : CWE-327 (Broken Crypto Algorithm — MD5/SHA1/DES/RC4),
 *                CWE-326 (Inadequate Encryption Strength — 56-bit DES, 512-bit RSA),
 *                CWE-330 (Weak PRNG — java.util.Random),
 *                CWE-321 (Hardcoded Cryptographic Key),
 *                CWE-325 (Missing Required Cryptographic Step — no MAC/HMAC)
 * Crypto       : demonstrates every common Java crypto anti-pattern
 */
public class CryptoService {

    // CWE-321 — Hardcoded AES key: rotated keys impossible, trivially extracted
    private static final byte[] AES_KEY = "hardcoded-aes-ke".getBytes();  // 128-bit
    private static final byte[] DES_KEY = "8bytekey".getBytes();           // 56-bit
    // Hardcoded IV — every message encrypted with same IV leaks key-stream relationships
    private static final byte[] STATIC_IV = "0000000000000000".getBytes();

    // CWE-327 — MD5: broken collision resistance; trivially rainbow-table reversed
    public String hashWithMD5(String input) throws NoSuchAlgorithmException {
        return Base64.getEncoder().encodeToString(
            MessageDigest.getInstance("MD5").digest(input.getBytes())
        );
    }

    // CWE-327 — SHA-1: NIST deprecated for digital signatures (SHAttered attack)
    public String hashWithSHA1(String input) throws NoSuchAlgorithmException {
        return Base64.getEncoder().encodeToString(
            MessageDigest.getInstance("SHA-1").digest(input.getBytes())
        );
    }

    // CWE-327 + CWE-326 — DES-ECB: 56-bit key brute-forceable in hours; ECB reveals patterns
    public byte[] desEncrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(DES_KEY, "DES"));
        return cipher.doFinal(plaintext.getBytes());
    }

    // CWE-327 — RC4 (ARCFOUR): broken stream cipher, forbidden in TLS 1.3
    public byte[] rc4Encrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("ARCFOUR");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(AES_KEY, "ARCFOUR"));
        return cipher.doFinal(plaintext.getBytes());
    }

    // CWE-326 — AES-ECB: correct key size but deterministic; identical blocks → identical ciphertext
    public byte[] aesEcbEncrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(AES_KEY, "AES"));
        return cipher.doFinal(plaintext.getBytes());
    }

    // CWE-325 — AES-CBC without HMAC: no integrity check; vulnerable to padding oracle
    public byte[] aesCbcNoMac(String plaintext) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(STATIC_IV);  // Static IV reuse
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(AES_KEY, "AES"), iv);
        return cipher.doFinal(plaintext.getBytes());
    }

    // CWE-326 — 512-bit RSA: broken since ~2000, NIST requires 2048 minimum
    public KeyPair generateWeakRSA() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(512);  // Far below NIST SP 800-131A minimum of 2048
        return kpg.generateKeyPair();
    }

    // CWE-330 — java.util.Random is not cryptographically secure; predictable from seed
    public String generateOTP() {
        java.util.Random rng = new java.util.Random(System.currentTimeMillis());
        return String.format("%06d", rng.nextInt(1_000_000));
    }

    // CWE-330 — Math.random() for security token generation
    public String generatePasswordResetToken() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            sb.append((int)(Math.random() * 36));
        }
        return sb.toString();
    }
}
