package com.demo.taint.sources;
import com.auth0.jwt.JWT;
public class SRC13_jwt_claim {
    public void handle(String token) throws Exception {
        String cmd = JWT.decode(token).getClaim("cmd").asString(); // SOURCE jwt claim
        Runtime.getRuntime().exec("echo " + cmd); // SINK
    }
}
