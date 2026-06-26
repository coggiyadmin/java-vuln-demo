package com.demo.taint.attack.app;
import javax.servlet.http.*;
public class As_sqli_app {
  public void handle(HttpServletRequest req) throws Exception {
    String n = req.getParameter("n");
    java.sql.DriverManager.getConnection("jdbc:sqlite::memory:")
      .createStatement().execute("SELECT * FROM u WHERE n='" + n + "'");
  }
}
