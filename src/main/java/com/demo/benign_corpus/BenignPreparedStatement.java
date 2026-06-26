package com.demo.benign_corpus;

import java.sql.*;

/** TN — JDBC prepared statement. */
public class BenignPreparedStatement {
    public String lookup(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT name FROM users WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getString(1) : "";
            }
        }
    }
}
