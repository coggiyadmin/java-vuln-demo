package com.demo.sanitizer_placement;
import javax.servlet.http.*;
/** SAN-P08 — partial strip weak sanitizer. */
public class SanP08PartialStrip {
  public void handle(HttpServletRequest req) throws Exception {
    String t = req.getParameter("q").replace("<", "");
    Runtime.getRuntime().exec("grep " + t);
  }
}
