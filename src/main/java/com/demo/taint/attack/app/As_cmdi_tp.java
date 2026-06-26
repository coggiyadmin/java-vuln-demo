package com.demo.taint.attack.app;
import javax.servlet.http.*;
public class As_cmdi_app {
  public void handle(HttpServletRequest req) throws Exception {
    String q = req.getParameter("q");
    Runtime.getRuntime().exec("grep " + q);
  }
}
