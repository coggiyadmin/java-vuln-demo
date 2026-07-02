package com.demo.sanitizer_placement;
import javax.servlet.http.*;
/** SAN-P03 — sanitizer in callee, sink in caller. */
public class SanP03CalleeSink {
  void sink(String v) throws Exception { Runtime.getRuntime().exec("grep " + v); }
  public void handle(HttpServletRequest req) throws Exception {
    sink(req.getParameter("q"));
  }
}
