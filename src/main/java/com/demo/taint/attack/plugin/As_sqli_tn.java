package com.demo.taint.attack.plugin;
public class As_sqli_plugin {
  public void publicQuery(String name) throws Exception {
    java.sql.DriverManager.getConnection("jdbc:sqlite::memory:")
      .createStatement().execute("SELECT * FROM u WHERE n='" + name + "'");
  }
}
