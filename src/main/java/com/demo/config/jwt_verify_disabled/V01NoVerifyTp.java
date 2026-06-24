package com.demo.config.jwt_verify_disabled;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
public class V01NoVerifyTp {
    public DecodedJWT decode(String token) {
        return JWT.decode(token); // SINK CWE-347 — no signature verify
    }
}
