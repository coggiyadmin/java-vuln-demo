package com.demo.config.hardcoded_secrets;

public class V11PrivateKeyTp {
    private static final String PRIVATE_KEY =
        "-----BEGIN RSA PRIVATE KEY-----\n" +
        "MIIEowIBAAKCAQEA1c3EXAMPLEKEYMATERIALdoNotUse0000\n" +
        "-----END RSA PRIVATE KEY-----"; // SINK CWE-798 embedded private key
    public String sign() { return PRIVATE_KEY; }
}
