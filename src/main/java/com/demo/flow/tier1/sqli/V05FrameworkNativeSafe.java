package com.demo.flow.tier1.sqli;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
public class V05FrameworkNativeSafe {
    public void run(HttpServletRequest req) throws Exception {
        Connection c = DriverManager.getConnection("jdbc:sqlite:app.db");
        PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE name=?");
        ps.setString(1, req.getParameter("name"));
        ps.executeQuery();
    }
}
