package com.demo.xf;
import java.sql.*;
public class XfHelper {
    public static ResultSet run(Connection c, String name) throws SQLException {
        return c.createStatement().executeQuery("SELECT * FROM users WHERE n = " + name); // SINK CWE-89
    }
}
