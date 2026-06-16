package com.demo;

import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

/**
 * FALSE-NEGATIVE PROBE CORPUS — every method is a REAL SQL injection.
 *
 * The tainted value (`req.getParameter`) reaches an unparameterized
 * `Statement.executeQuery` sink, but via a flow pattern that taint engines
 * commonly drop (interprocedural, field, container, transform, alias, builder,
 * ternary). Any method that produces NO `sql_injection` finding is a FALSE
 * NEGATIVE — a missed real vulnerability.
 *
 * `direct()` is the control: it MUST fire. The rest probe flow-sensitivity.
 */
public class FalseNegativeCorpus {

    private String storedName;  // for the field-sensitivity probe

    // CONTROL — direct flow, must fire
    public ResultSet direct(HttpServletRequest req, Connection conn) throws SQLException {
        String u = req.getParameter("u");
        return conn.createStatement().executeQuery(
            "SELECT * FROM users WHERE name = '" + u + "'");
    }

    // 1. INTERPROCEDURAL — taint passed into a helper that holds the sink
    public ResultSet interprocedural(HttpServletRequest req, Connection conn) throws SQLException {
        String u = req.getParameter("u");
        return runQuery(conn, u);
    }
    private ResultSet runQuery(Connection conn, String name) throws SQLException {
        return conn.createStatement().executeQuery(
            "SELECT * FROM users WHERE name = '" + name + "'");
    }

    // 2. FIELD-SENSITIVE — taint stored in an instance field, used later
    public void storeName(HttpServletRequest req) {
        this.storedName = req.getParameter("u");
    }
    public ResultSet useStoredField(Connection conn) throws SQLException {
        return conn.createStatement().executeQuery(
            "SELECT * FROM users WHERE name = '" + this.storedName + "'");
    }

    // 3. CONTAINER (List) — taint stored in a list element, retrieved
    public ResultSet viaList(HttpServletRequest req, Connection conn) throws SQLException {
        List<String> names = new ArrayList<>();
        names.add(req.getParameter("u"));
        return conn.createStatement().executeQuery(
            "SELECT * FROM users WHERE name = '" + names.get(0) + "'");
    }

    // 4. CONTAINER (Map) — taint stored as a map value, retrieved
    public ResultSet viaMap(HttpServletRequest req, Connection conn) throws SQLException {
        Map<String, String> m = new HashMap<>();
        m.put("name", req.getParameter("u"));
        return conn.createStatement().executeQuery(
            "SELECT * FROM users WHERE name = '" + m.get("name") + "'");
    }

    // 5. STRING TRANSFORM — toUpperCase preserves taint
    public ResultSet viaTransform(HttpServletRequest req, Connection conn) throws SQLException {
        String u = req.getParameter("u").toUpperCase().trim();
        return conn.createStatement().executeQuery(
            "SELECT * FROM users WHERE name = '" + u + "'");
    }

    // 6. ALIASING — taint copied through intermediate variables
    public ResultSet viaAlias(HttpServletRequest req, Connection conn) throws SQLException {
        String a = req.getParameter("u");
        String b = a;
        String c = b;
        return conn.createStatement().executeQuery(
            "SELECT * FROM users WHERE name = '" + c + "'");
    }

    // 7. STRINGBUILDER — taint accumulated via append()
    public ResultSet viaBuilder(HttpServletRequest req, Connection conn) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM users WHERE name = '");
        sb.append(req.getParameter("u"));
        sb.append("'");
        return conn.createStatement().executeQuery(sb.toString());
    }

    // 8. TERNARY — taint flows through a conditional expression
    public ResultSet viaTernary(HttpServletRequest req, Connection conn) throws SQLException {
        String u = req.getParameter("u");
        String q = (u != null)
            ? "SELECT * FROM users WHERE name = '" + u + "'"
            : "SELECT 1";
        return conn.createStatement().executeQuery(q);
    }
}
