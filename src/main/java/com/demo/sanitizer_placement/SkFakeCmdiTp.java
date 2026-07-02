package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFakeCmdiTp {
  public void handle(HttpServletRequest req) throws Exception {
    String q = req.getParameter("q").replace(";", "");
    Runtime.getRuntime().exec("grep " + q);
  }
}
