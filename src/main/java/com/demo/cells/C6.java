package com.demo.cells;
import java.sql.*; import java.util.*; import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
public class C6 {
  public void run(HttpServletRequest req, Connection cn) throws Exception {
    String raw=req.getParameter("u"); String e=java.net.URLEncoder.encode(raw,"UTF-8"); Runtime.getRuntime().exec("echo "+e);
  }
}
