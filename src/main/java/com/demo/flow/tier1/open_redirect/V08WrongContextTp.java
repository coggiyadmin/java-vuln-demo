package com.demo.flow.tier1.open_redirect;
import javax.servlet.http.*;
import java.sql.*;
public class V08WrongContextTp {
    public void go(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String nxt = req.getParameter("next");
        DriverManager.getConnection("jdbc:sqlite::memory:")
          .createStatement().execute("SELECT * FROM u WHERE n='" + nxt + "'");
        res.sendRedirect(nxt);
    }
}
