package com.demo;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** SAFE mirror — WeakPasswordHash; slow, salted bcrypt KDF. Expect 0 findings. */
public class SafeWeakPasswordHash {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public String register(HttpServletRequest req) {
        return ENCODER.encode(req.getParameter("password"));   // slow, salted KDF
    }
}
