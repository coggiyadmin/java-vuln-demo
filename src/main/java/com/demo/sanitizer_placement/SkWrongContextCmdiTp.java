package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkWrongContextCmdiTp {
  public void handle(HttpServletRequest req) throws Exception {
    String q = java.net.URLEncoder.encode(req.getParameter("q"), "UTF-8");
    Runtime.getRuntime().exec("grep " + q);
  }
}
