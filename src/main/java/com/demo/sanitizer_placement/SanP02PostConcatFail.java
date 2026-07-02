package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import java.net.URLEncoder;
/** SAN-P02 — sanitizer after concat (must fail). */
public class SanP02PostConcatFail {
  public void run(HttpServletRequest req) throws Exception {
    String t = req.getParameter("q");
    Runtime.getRuntime().exec("grep " + t + " /var/log/app.log");
  }
}
