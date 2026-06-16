package com.demo.cells;
import java.sql.*; import java.util.*; import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
public class C2 {
  public void run(HttpServletRequest req, Connection cn) throws Exception {
    String u=req.getParameter("u"); if(u.length()>1000){ cn.createStatement().executeQuery("SELECT "+u); }
  }
}
