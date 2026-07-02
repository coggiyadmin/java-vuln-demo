package com.demo.profile.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;

/** TN — library repository with prepared statement (#169). */
public class PublicApiRepository {
    public String lookup(Connection conn, int id) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement("SELECT name FROM users WHERE id = ?")) {
            ps.setInt(1, id);
            try (var rs = ps.executeQuery()) {
                return rs.next() ? rs.getString(1) : "";
            }
        }
    }
}
