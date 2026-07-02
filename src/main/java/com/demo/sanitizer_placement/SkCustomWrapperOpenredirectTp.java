package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkCustomWrapperOpenredirectTp {
  private static String companySanitize(String v) {
    return v.replaceFirst("(?i)javascript:", "");
  }
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String nxt = companySanitize(req.getParameter("next"));
    resp.sendRedirect(nxt);
  }
}
