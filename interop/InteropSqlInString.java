package com.demo.interop;

import java.sql.*;

/** IL-1 polyglot — Java → SQL DSL (CWE-89). */
public class InteropSqlInString {
    public void lookup(String name) throws SQLException {
        // SOURCE: caller-supplied HTTP param bound at controller layer
        // SINK (CWE-89): SQL assembled in a Java string literal.
        String q = "SELECT * FROM users WHERE name = '" + name + "'";
        Connection c = DriverManager.getConnection("jdbc:sqlite:app.db");
        c.createStatement().executeQuery(q);
    }
}
