package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkWrongContextOpenredirectTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String nxt = req.getParameter("next").replace("<", "&lt;");
    resp.sendRedirect(nxt);
  }
}
