package com.demo;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.security.SecureRandom;
import java.sql.*;
import java.util.*;
import javax.servlet.http.*;
import javax.xml.parsers.*;
import org.owasp.encoder.Encode;
import org.owasp.esapi.ESAPI;

/**
 * NEGATIVE TEST FILE — secure equivalents of every vulnerable pattern.
 *
 * This file flows user input through documented sanitizers to each sink type.
 * The scanner MUST produce ZERO security findings here. Any finding is a
 * FALSE POSITIVE and should be filed against cognium-dev.
 *
 * Sanitizers exercised (from circle-ir config-loader.ts):
 *   sql_injection      → PreparedStatement.setString
 *   xss                → Encode.forHtml (OWASP Java Encoder)
 *   path_traversal     → File.getCanonicalPath + prefix check
 *   ssrf               → isAllowedHost allowlist
 *   ldap_injection     → ESAPI.encoder().encodeForLDAP
 *   xxe                → DocumentBuilderFactory.setFeature(disallow-doctype)
 *   weak_random        → SecureRandom (not java.util.Random)
 */
public class SafeService {

    private static final String UPLOAD_ROOT = "/var/app/uploads";
    private static final Set<String> ALLOWED_HOSTS =
        Set.of("api.internal.example.com", "cdn.example.com");

    // SAFE sql — parameterized PreparedStatement, no concatenation
    public ResultSet getUser(HttpServletRequest request, Connection conn) throws SQLException {
        String username = request.getParameter("username");
        PreparedStatement ps = conn.prepareStatement(
            "SELECT * FROM users WHERE username = ?");
        ps.setString(1, username);   // sanitizer: taint cleared
        return ps.executeQuery();
    }

    // SAFE xss — OWASP Encoder escapes before rendering
    public String renderProfile(HttpServletRequest request) {
        String name = request.getParameter("name");
        String safe = Encode.forHtml(name);   // sanitizer: taint cleared
        return "<div class=\"profile\"><h2>" + safe + "</h2></div>";
    }

    // SAFE path — canonicalize and verify the result stays under UPLOAD_ROOT
    public String readUpload(HttpServletRequest request) throws IOException {
        String filename = request.getParameter("file");
        File base = new File(UPLOAD_ROOT);
        File target = new File(base, filename);
        String canonical = target.getCanonicalPath();   // sanitizer: taint cleared
        if (!canonical.startsWith(base.getCanonicalPath() + File.separator)) {
            throw new SecurityException("path traversal blocked");
        }
        return new String(Files.readAllBytes(Paths.get(canonical)));
    }

    // SAFE ssrf — host validated against an allowlist before the request
    public String fetchResource(HttpServletRequest request) throws IOException {
        String urlParam = request.getParameter("url");
        URL url = new URL(urlParam);
        if (!isAllowedHost(url.getHost())) {   // sanitizer: taint cleared
            throw new SecurityException("host not allowed");
        }
        try (InputStream in = url.openStream()) {
            return new String(in.readAllBytes());
        }
    }

    private boolean isAllowedHost(String host) {
        return ALLOWED_HOSTS.contains(host);
    }

    // SAFE ldap — ESAPI encodes the user value before it enters the filter
    public String buildLdapFilter(HttpServletRequest request) {
        String uid = request.getParameter("uid");
        String encoded = ESAPI.encoder().encodeForLDAP(uid);   // sanitizer: taint cleared
        return "(&(objectClass=person)(uid=" + encoded + "))";
    }

    // SAFE xxe — external entities and DOCTYPE disabled before parse
    public org.w3c.dom.Document parseXmlSafely(HttpServletRequest request) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        byte[] body = request.getInputStream().readAllBytes();
        return builder.parse(new ByteArrayInputStream(body));
    }

    // SAFE random — SecureRandom for token generation, not java.util.Random
    public String generateToken() {
        SecureRandom rng = new SecureRandom();
        byte[] bytes = new byte[32];
        rng.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    // SAFE config — credentials read from the environment, nothing hardcoded
    public String dbPassword() {
        return System.getenv("DB_PASSWORD");
    }
}
