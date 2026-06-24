package com.demo.config.tls_verify_disabled;

import javax.net.ssl.*;
public class V01SkipVerifyTp {
    public SSLContext ctx() throws Exception {
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(java.security.cert.X509Certificate[] c, String a) {}
            public void checkServerTrusted(java.security.cert.X509Certificate[] c, String a) {}
            public java.security.cert.X509Certificate[] getAcceptedIssuers() { return new java.security.cert.X509Certificate[0]; }
        }}, new java.security.SecureRandom());
        return sc; // SINK CWE-295
    }
}
