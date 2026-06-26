package com.demo.taint.sanitize.kinds;
import java.sql.*;
public class SK03_ssrf {
  public void lookup(String n) throws Exception {
    Connection c = DriverManager.getConnection("jdbc:sqlite::memory:");
    PreparedStatement ps = c.prepareStatement("SELECT * FROM u WHERE n=?");
    ps.setString(1, n);
    ps.executeQuery(); // SK-03 TN
  }
}
