package com.demo.taint.sanitize;
import javax.servlet.http.*;
public class SAN06_tp {
  public void handle(HttpServletRequest req) throws Exception {
    Runtime.getRuntime().exec("grep " + req.getParameter("q"));
  }
}
