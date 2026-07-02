package com.demo.interop;
import java.sql.*;

public class SafeInteropXmlConfigSql {
    public void lookup(String name) throws Exception {
        PreparedStatement ps = DriverManager.getConnection("jdbc:sqlite::memory:")
            .prepareStatement("SELECT * FROM u WHERE n=?");
        ps.setString(1, name);
        ps.executeQuery();
    }
}
