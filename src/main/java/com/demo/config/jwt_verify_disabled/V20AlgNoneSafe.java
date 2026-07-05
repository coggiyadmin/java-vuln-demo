package com.demo.config.jwt_verify_disabled;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
public class V20AlgNoneSafe {
    public void verify(String token, java.security.interfaces.RSAPublicKey key) {
        JWT.require(Algorithm.RSA256(key, null)).build().verify(token); // verified
    }
}
