package com.demo.config.tls_verify_disabled;

import javax.net.ssl.SSLContext;
public class V20WeakProtocolSafe {
    public SSLContext ctx() throws Exception {
        return SSLContext.getInstance("TLSv1.2"); // TLS 1.2
    }
}
