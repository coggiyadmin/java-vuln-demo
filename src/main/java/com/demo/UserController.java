package com.demo;

import java.sql.*;
import java.util.Base64;
import java.security.MessageDigest;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * DEMO FILE — intentional vulnerabilities for security scanner showcase.
 *
 * CWE findings : CWE-89 (SQL Injection), CWE-798 (Hardcoded Credentials),
 *                CWE-327 (Weak Crypto), CWE-326 (Inadequate Key Strength),
 *                CWE-330 (Weak PRNG)
 * Secrets       : hardcoded DB password, AWS keys, JWT secret
 * Crypto        : MD5 password hashing, DES-ECB encryption
 */
public class UserController {

    // SECRETS — CWE-798: Hardcoded credentials committed to source
    private static final String DB_URL      = "jdbc:mysql://prod-db.internal:3306/users";
    private static final String DB_USER     = "root";
    private static final String DB_PASS     = "Sup3rS3cr3tP@ssw0rd!";
    private static final String AWS_KEY_ID  = "AKIAIOSFODNN7EXAMPLE";
    private static final String AWS_SECRET  = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
    private static final String JWT_SECRET  = "my-super-secret-jwt-key-do-not-share";
    private static final String GITHUB_PAT  = "ghp_ExamplePersonalAccessToken12345678";

    // CWE FINDING — CWE-89: SQL Injection via string concatenation
    public ResultSet getUserByUsername(Connection conn, String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        // Attack: username = "' OR '1'='1" dumps entire table
        return conn.createStatement().executeQuery(query);
    }

    // CWE FINDING — CWE-89: SQL Injection in authentication path (critical)
    public boolean login(Connection conn, String user, String password) throws SQLException {
        String sql = "SELECT id FROM users WHERE username='" + user
                   + "' AND password='" + password + "'";
        // Attack: user = "admin'--" bypasses password check entirely
        ResultSet rs = conn.createStatement().executeQuery(sql);
        return rs.next();
    }

    // CWE FINDING — CWE-89: Second-order SQL Injection via stored username
    public void updateEmail(Connection conn, String username, String newEmail) throws SQLException {
        String sql = "UPDATE users SET email='" + newEmail
                   + "' WHERE username='" + username + "'";
        conn.createStatement().executeUpdate(sql);
    }

    // CRYPTO — CWE-327: MD5 is cryptographically broken; trivially rainbow-table attacked
    public String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hash);
    }

    // CRYPTO — CWE-326: 56-bit DES key is brute-forceable; ECB leaks block patterns
    public byte[] encryptData(String data, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.substring(0, 8).getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data.getBytes());
    }

    // CRYPTO — CWE-330: java.util.Random seeded with timestamp is predictable
    public String generateSessionToken(String userId) {
        java.util.Random rng = new java.util.Random(System.currentTimeMillis());
        int n = rng.nextInt(999999);
        return userId + "-" + String.format("%06d", n);
    }

    // LICENSE / HYGIENE — returns stack traces to the caller (information disclosure)
    public String safeCall(Connection conn, String id) {
        try {
            return getUserByUsername(conn, id).toString();
        } catch (Exception e) {
            return "Error: " + e.toString();  // Full stack trace leaked to client
        }
    }
}
