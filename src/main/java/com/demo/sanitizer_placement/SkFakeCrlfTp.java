package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFakeCrlfTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) {
    String loc = req.getParameter("url").replace("SAFE", "");
    resp.setHeader("Location", loc);
  }
}
