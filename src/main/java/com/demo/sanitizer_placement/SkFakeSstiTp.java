package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import org.apache.velocity.app.Velocity;
public class SkFakeSstiTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String n = req.getParameter("n").replace("SAFE", "");
    Velocity.evaluate(null, resp.getWriter(), "v", "<p>" + n + "</p>");
  }
}
