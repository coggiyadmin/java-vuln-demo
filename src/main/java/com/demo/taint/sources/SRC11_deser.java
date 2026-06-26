package com.demo.taint.sources;
import com.fasterxml.jackson.databind.*;
public class SrcDeser {
  public void handle(String raw) throws Exception {
    JsonNode obj = new ObjectMapper().readTree(raw); // SOURCE SRC-11
    String q = obj.get("q").asText();
    java.sql.DriverManager.getConnection("jdbc:sqlite::memory:")
      .createStatement().execute("SELECT * FROM t WHERE n='" + q + "'");
  }
}
