package com.demo.flow.tier1.sqli;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
public class V07HardeningSafe {
    public void run(HttpServletRequest req) throws Exception {
        String n = req.getParameter("name");
        if (!n.matches("[A-Za-z0-9]+")) throw new SecurityException();
        PreparedStatement ps = DriverManager.getConnection("jdbc:sqlite::memory:")
          .prepareStatement("SELECT * FROM users WHERE name=?");
        ps.setString(1, n);
        ps.executeQuery();
    }
}
