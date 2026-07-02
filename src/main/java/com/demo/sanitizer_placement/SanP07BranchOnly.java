package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import java.net.URLEncoder;
/** SAN-P07 — sanitizer on branch only. */
public class SanP07BranchOnly {
  public void handle(HttpServletRequest req) throws Exception {
    String t = req.getParameter("q");
    if (t.length() > 100) t = URLEncoder.encode(t, "UTF-8");
    Runtime.getRuntime().exec("grep " + t);
  }
}
