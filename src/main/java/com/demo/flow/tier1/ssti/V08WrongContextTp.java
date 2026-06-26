package com.demo.flow.tier1.ssti;
import org.apache.velocity.app.Velocity;
import javax.servlet.http.*;
import java.sql.*;
public class V08WrongContextTp {
    public void render(HttpServletRequest req) throws Exception {
        String n = req.getParameter("n");
        DriverManager.getConnection("jdbc:sqlite::memory:")
          .createStatement().execute("SELECT * FROM u WHERE n='" + n + "'");
        Velocity.evaluate(null, req.getWriter(), "v", "<p>" + n + "</p>");
    }
}
