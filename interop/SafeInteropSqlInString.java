package com.demo.interop;

import java.sql.*;

/** SAFE mirror — PreparedStatement, no concatenated SQL. */
public class SafeInteropSqlInString {
    public void lookup(String name) throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:sqlite:app.db");
        PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE name = ?");
        ps.setString(1, name);
        ps.executeQuery();
    }
}
