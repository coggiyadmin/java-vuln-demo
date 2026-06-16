package com.demo;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 * ZERO-FP RESEARCH CORPUS — patterns that LOOK tainted but are provably safe.
 *
 * Each method models a documented hard case for taint analysis (the categories
 * OWASP Benchmark / CodeQL precision research use to measure false-positive
 * rate). The scanner MUST produce ZERO security findings here. Any finding is a
 * FALSE POSITIVE — our product's #1 USP is zero FP.
 *
 * Categories:
 *   1. Type-cast sanitization   — int/long/UUID/enum cannot carry injection
 *   2. Regex/format validation  — input matched against a strict allowlist regex
 *   3. Switch/map → constant     — user input only selects among constants
 *   4. Reassignment-to-constant — tainted var overwritten before the sink
 *   5. Bounded enum/whitelist    — value constrained to a fixed set
 *   6. Dead / unreachable sink   — guarded by if(false) / after return
 */
public class FalsePositiveCorpus {

    // 1. TYPE-CAST — Integer.parseInt: an int cannot carry a SQLi payload
    public ResultSet byId(HttpServletRequest req, Connection conn) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));  // throws on non-numeric
        Statement st = conn.createStatement();
        // Concatenation of an int is safe — no string injection is representable
        return st.executeQuery("SELECT * FROM users WHERE id = " + id);
    }

    // 1b. TYPE-CAST — UUID.fromString validates format; result cannot inject
    public ResultSet byUuid(HttpServletRequest req, Connection conn) throws SQLException {
        UUID uuid = UUID.fromString(req.getParameter("uuid"));  // throws on bad format
        Statement st = conn.createStatement();
        return st.executeQuery("SELECT * FROM sessions WHERE sid = '" + uuid + "'");
    }

    // 2. REGEX VALIDATION — strict allowlist pattern before use in a path
    private static final Pattern SAFE_NAME = Pattern.compile("^[a-zA-Z0-9_]{1,32}$");
    public String readConfig(HttpServletRequest req) throws IOException {
        String name = req.getParameter("name");
        if (!SAFE_NAME.matcher(name).matches()) {
            throw new IllegalArgumentException("invalid name");
        }
        // name is now constrained to [a-zA-Z0-9_] — no traversal possible
        return new String(java.nio.file.Files.readAllBytes(
            java.nio.file.Paths.get("/etc/app/" + name + ".conf")));
    }

    // 3. SWITCH → CONSTANT — user input only selects among hardcoded commands
    public String runReport(HttpServletRequest req) throws Exception {
        String type = req.getParameter("type");
        String cmd;
        switch (type) {
            case "daily":   cmd = "/usr/bin/report-daily";   break;
            case "weekly":  cmd = "/usr/bin/report-weekly";  break;
            default:        cmd = "/usr/bin/report-default"; break;
        }
        // cmd is always one of three constants — user input never reaches exec
        Process p = Runtime.getRuntime().exec(cmd);
        return new String(p.getInputStream().readAllBytes());
    }

    // 4. REASSIGNMENT — tainted value overwritten with a constant before the sink
    public ResultSet lookup(HttpServletRequest req, Connection conn) throws SQLException {
        String table = req.getParameter("table");
        table = "users";  // overwrite: the tainted value is discarded
        Statement st = conn.createStatement();
        return st.executeQuery("SELECT * FROM " + table + " LIMIT 10");
    }

    // 5. BOUNDED ENUM — value validated against a fixed allowlist set
    private static final Set<String> COLUMNS = Set.of("name", "email", "created_at");
    public ResultSet sortBy(HttpServletRequest req, Connection conn) throws SQLException {
        String col = req.getParameter("sort");
        if (!COLUMNS.contains(col)) col = "name";  // constrained to known columns
        Statement st = conn.createStatement();
        return st.executeQuery("SELECT * FROM users ORDER BY " + col);
    }

    // 6. DEAD CODE — sink is unreachable (guarded by a compile-time-false constant)
    private static final boolean DEBUG = false;
    public void debugExec(HttpServletRequest req) throws Exception {
        String cmd = req.getParameter("cmd");
        if (DEBUG) {
            Runtime.getRuntime().exec(cmd);  // unreachable — DEBUG is always false
        }
    }
}
