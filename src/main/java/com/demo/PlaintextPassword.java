package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;

/** CWE-256 — Plaintext Storage of a Password. Stored as-is, no hashing. NO finding = FN. */
public class PlaintextPassword {
    public void register(HttpServletRequest req, Connection c) throws Exception {
        String user = req.getParameter("user");
        String password = req.getParameter("password");   // SOURCE
        PreparedStatement ps = c.prepareStatement("INSERT INTO users(name, pw) VALUES (?, ?)");
        ps.setString(1, user);
        ps.setString(2, password);   // plaintext password persisted → CWE-256
        ps.executeUpdate();
    }
}
