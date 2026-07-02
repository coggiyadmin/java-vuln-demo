package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkCustomWrapperCrlfTp {
  private static String companySanitize(String v) { return v.replace('\r', ""); }
  public void handle(HttpServletRequest req, HttpServletResponse resp) {
    String nxt = companySanitize(req.getParameter('next'));
    resp.setHeader('Location', '/home?u=' + nxt);
  }
}
