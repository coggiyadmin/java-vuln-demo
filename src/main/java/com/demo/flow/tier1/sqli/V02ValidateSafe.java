package com.demo.flow.tier1.sqli;
import java.sql.*; import javax.servlet.http.HttpServletRequest;
public class V02ValidateSafe {
    public void run(HttpServletRequest req, Connection db) throws Exception {
        String name = req.getParameter("name");
        if (!name.matches("[a-zA-Z0-9]+")) throw new SecurityException();
        PreparedStatement ps = db.prepareStatement("SELECT * FROM users WHERE name=?");
        ps.setString(1, name); ps.executeQuery();
    }
}
