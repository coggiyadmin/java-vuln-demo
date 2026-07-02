package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkHardeningOpenredirectTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String nxt = req.getParameter("next");
    if (!nxt.startsWith("http://") && !nxt.startsWith("https://")) {
      nxt = "https://example.com/" + nxt;
    }
    resp.sendRedirect(nxt);
  }
}
