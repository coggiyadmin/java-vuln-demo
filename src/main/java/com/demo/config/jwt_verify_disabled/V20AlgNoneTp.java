package com.demo.config.jwt_verify_disabled;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
public class V20AlgNoneTp {
    public void verify(String token) {
        JWT.decode(token); // SINK decode without .require(Algorithm...).verify()
    }
}
