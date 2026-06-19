package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** SAFE mirror — PlaintextPassword; bcrypt hash stored, never cleartext. Expect 0. */
public class SafePlaintextPassword {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public void register(HttpServletRequest req, Connection c) throws Exception {
        String user = req.getParameter("user");
        String hash = ENCODER.encode(req.getParameter("password"));   // one-way hash
        PreparedStatement ps = c.prepareStatement("INSERT INTO users(name, pw) VALUES (?, ?)");
        ps.setString(1, user);
        ps.setString(2, hash);
        ps.executeUpdate();
    }
}
