package com.demo;

import org.mindrot.jbcrypt.BCrypt;

/** SAFE mirror — RecoverablePassword. One-way bcrypt hash. */
public class SafeRecoverablePassword {
    public String store(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
