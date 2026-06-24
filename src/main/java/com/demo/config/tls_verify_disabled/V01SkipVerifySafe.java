package com.demo.config.tls_verify_disabled;

import javax.net.ssl.SSLContext;
public class V01SkipVerifySafe {
    public SSLContext ctx() throws Exception {
        return SSLContext.getDefault();
    }
}
