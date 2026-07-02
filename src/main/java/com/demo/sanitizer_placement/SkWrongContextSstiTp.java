package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import org.apache.velocity.app.Velocity;
public class SkWrongContextSstiTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String n = req.getParameter("n").replace("'", "''");
    Velocity.evaluate(null, resp.getWriter(), "v", "<p>" + n + "</p>");
  }
}
