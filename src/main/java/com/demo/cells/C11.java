package com.demo.cells;
import java.sql.*; import java.util.*; import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
public class C11 {
  public void run(HttpServletRequest req, Connection cn) throws Exception {
    String u=req.getParameter("u"); Runtime.getRuntime().exec("echo "+u); cn.createStatement().executeQuery("SELECT "+u);
  }
}
