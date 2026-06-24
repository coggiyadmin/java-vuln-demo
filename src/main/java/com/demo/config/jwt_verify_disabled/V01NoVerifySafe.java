package com.demo.config.jwt_verify_disabled;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
public class V01NoVerifySafe {
    public DecodedJWT decode(String token, String secret) {
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }
}
