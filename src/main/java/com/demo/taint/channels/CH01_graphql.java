package com.demo.taint.channels;
import javax.servlet.http.*;
import java.sql.*;
public class CH01_graphql {
  public void resolveUser(HttpServletRequest req) throws Exception {
    String id = req.getParameter("id"); // SOURCE graphql arg
    DriverManager.getConnection("jdbc:sqlite::memory:")
      .createStatement().execute("SELECT * FROM u WHERE id='" + id + "'");
  }
}
