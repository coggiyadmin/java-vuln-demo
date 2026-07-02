package com.demo.sanitizer_placement;
import javax.servlet.http.*;
/** SAN-P04 — sanitizer across alias hop. */
public class SanP04AliasHop {
  public void handle(HttpServletRequest req) throws Exception {
    String x = req.getParameter("q");
    String y = x;
    Runtime.getRuntime().exec("grep " + y);
  }
}
