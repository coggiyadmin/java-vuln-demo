package com.demo.config.tls_verify_disabled;

import javax.net.ssl.SSLContext;
public class V20WeakProtocolTp {
    public SSLContext ctx() throws Exception {
        return SSLContext.getInstance("TLSv1"); // SINK weak protocol (TLS 1.0)
    }
}
