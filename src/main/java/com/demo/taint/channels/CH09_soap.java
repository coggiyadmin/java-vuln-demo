package com.demo.taint.channels;
import java.sql.*;
public class CH09_soap {
  public void getUser(Connection c, String soapArg) throws Exception {
    c.createStatement().executeQuery("SELECT * FROM u WHERE id='" + soapArg + "'"); // SINK CWE-89
  }
}
