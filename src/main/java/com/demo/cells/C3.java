package com.demo.cells;
import java.sql.*; import java.util.*; import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
public class C3 {
  public void run(HttpServletRequest req, Connection cn) throws Exception {
    for(String v: req.getParameterValues("p")){ String x=v; cn.createStatement().executeQuery("SELECT "+x); }
  }
}
