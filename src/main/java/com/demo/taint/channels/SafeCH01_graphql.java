package com.demo.taint.channels;
import java.sql.*;
public class SafeCH01_graphql {
  public void resolve(String id) throws Exception {
    if (!id.matches("^[0-9]+$")) return;
    try (Connection c = DriverManager.getConnection("jdbc:sqlite::memory:")) {
      PreparedStatement ps = c.prepareStatement("SELECT * FROM u WHERE id=?");
      ps.setString(1, id);
      ps.executeQuery();
    }
  }
}
