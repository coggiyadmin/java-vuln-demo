package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkHardeningCrlfTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) {
    String loc = req.getParameter("url").replace("\n", "");
    resp.setHeader("Location", loc);
  }
}
