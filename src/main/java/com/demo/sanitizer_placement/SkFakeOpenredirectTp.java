package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFakeOpenredirectTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String nxt = req.getParameter("next").replace("SAFE", "");
    resp.sendRedirect(nxt);
  }
}
