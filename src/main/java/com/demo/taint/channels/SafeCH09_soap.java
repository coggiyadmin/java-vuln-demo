package com.demo.taint.channels;
import java.sql.*;
public class SafeCH09_soap {
  public void getUser(Connection c, String soapArg) throws Exception {
    PreparedStatement ps = c.prepareStatement("SELECT * FROM u WHERE id=?");
    ps.setString(1, soapArg);
    ps.executeQuery();
  }
}
