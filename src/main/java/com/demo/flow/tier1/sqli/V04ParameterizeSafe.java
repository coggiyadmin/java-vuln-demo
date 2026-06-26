package com.demo.flow.tier1.sqli;
import java.sql.*; import javax.servlet.http.HttpServletRequest;
public class V04ParameterizeSafe {
    public void run(HttpServletRequest req, Connection db) throws Exception {
        PreparedStatement ps = db.prepareStatement("SELECT * FROM users WHERE name=?");
        ps.setString(1, req.getParameter("name")); ps.executeQuery();
    }
}
