package com.demo.cells;
import java.sql.*; import java.util.*; import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
public class C9 {
  public void run(HttpServletRequest req, Connection cn) throws Exception {
    String ex="Runtime.getRuntime().exec(x)"; cn.createStatement().executeQuery("SELECT 1");
  }
}
