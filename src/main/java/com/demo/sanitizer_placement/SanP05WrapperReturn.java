package com.demo.sanitizer_placement;
import javax.servlet.http.*;
/** SAN-P05 — sanitizer in wrapper returned to sink. */
public class SanP05WrapperReturn {
  String wrap(String x) { return x.replace("<", ""); }
  public void handle(HttpServletRequest req) throws Exception {
    Runtime.getRuntime().exec("grep " + wrap(req.getParameter("q")));
  }
}
