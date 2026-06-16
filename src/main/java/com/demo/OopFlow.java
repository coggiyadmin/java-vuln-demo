package com.demo;

import java.sql.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #5 — OOP OBJECT FLOW. Taint is injected via the constructor,
 * stored in a field, exposed through a getter, and reaches a SQL sink in
 * another method. Each is a REAL SQL injection; NO finding = FALSE NEGATIVE.
 */
public class OopFlow {

    private final String name;     // taint-carrying field

    // constructor-injected taint
    public OopFlow(HttpServletRequest req) {
        this.name = req.getParameter("u");
    }

    public String getName() {
        return this.name;          // getter exposes the tainted field
    }

    // 5a. field read directly in a sink method
    public ResultSet queryDirect(Connection conn) throws SQLException {
        return conn.createStatement().executeQuery(
            "SELECT * FROM users WHERE name = " + this.name);
    }

    // 5b. field read via getter into a sink
    public ResultSet queryViaGetter(Connection conn) throws SQLException {
        return conn.createStatement().executeQuery(
            "SELECT * FROM users WHERE name = " + getName());
    }
}
