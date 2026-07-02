package com.demo.sanitizer_placement;
import java.sql.*;
import javax.servlet.http.*;
public class SkFakeSqliTp {
  public void handle(HttpServletRequest req) throws Exception {
    String n = req.getParameter("n");
    Statement s = DriverManager.getConnection("jdbc:sqlite::memory:").createStatement();
    s.executeQuery("SELECT * FROM u WHERE n='" + n + "'");
  }
}
