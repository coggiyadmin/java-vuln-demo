package com.demo;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;
import javax.servlet.http.*;

/**
 * DEMO FILE — framework-level FALSE-NEGATIVE probes (Netty / Spring patterns).
 */
public class FrameworkCases {

    // CWE-295 — TrustManager accepts all certificates; hostname verification disabled.
    public HttpsURLConnection trustBypass(URL target) throws Exception {
        TrustManager[] trustAll = new TrustManager[] {
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] c, String t) {}
                public void checkServerTrusted(X509Certificate[] c, String t) {}
            }
        };
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, trustAll, new java.security.SecureRandom());
        HttpsURLConnection conn = (HttpsURLConnection) target.openConnection();
        conn.setSSLSocketFactory(ctx.getSocketFactory());
        conn.setHostnameVerifier((h, s) -> true);  // CWE-295
        return conn;
    }

    // CWE-444 — permissive HTTP/1.1 header parsing enables request smuggling.
    public String httpDecoderConfusion(byte[] raw) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(raw);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder headers = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            headers.append(line).append("\r\n");
            if (line.isEmpty()) break;
        }
        return headers.toString() + reader.lines().reduce("", String::concat);  // CWE-444
    }

    // CWE-400 — array sized from peer-declared length without bound check.
    public byte[] redisArrayAggregator(int declaredLen, InputStream peer) throws IOException {
        byte[] buf = new byte[declaredLen];  // CWE-400
        peer.read(buf);
        return buf;
    }

    // CWE-400 — unbounded multipart read retained after parse error.
    public void multipartLeak(HttpServletRequest req, OutputStream out) throws IOException {
        String boundary = req.getHeader("Content-Type").split("boundary=")[1];
        byte[] chunk = req.getInputStream().readAllBytes();
        out.write(("--" + boundary + "\r\n").getBytes());
        out.write(chunk);  // CWE-400
    }

    // CWE-22 + CWE-400 — versioned static path not canonicalized.
    public InputStream versionedResource(String versionedPath) throws FileNotFoundException {
        return new FileInputStream("/var/www/static/" + versionedPath);  // CWE-22
    }

    // CWE-89 — second-order: DB-stored path used unsanitized in query.
    public ResultSet versionedFromDb(Connection conn, String assetId) throws SQLException {
        ResultSet meta = conn.createStatement().executeQuery(
            "SELECT version_path FROM assets WHERE id = '" + assetId + "'");
        String path = meta.next() ? meta.getString("version_path") : "";
        return conn.createStatement().executeQuery(
            "SELECT content FROM static_files WHERE path = '" + path + "'");  // CWE-89
    }
}
