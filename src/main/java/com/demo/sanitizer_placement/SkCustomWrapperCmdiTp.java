package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkCustomWrapperCmdiTp {
  private static String companySanitize(String v) { return v.replace(";", ""); }
  public void handle(HttpServletRequest req) throws Exception {
    String q = companySanitize(req.getParameter("q"));
    Runtime.getRuntime().exec("grep " + q);
  }
}
