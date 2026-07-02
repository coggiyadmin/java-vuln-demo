package com.demo.sanitizer_placement;
import java.util.logging.*;
import javax.servlet.http.*;
public class SkFrameworkNativeLoginjTp {
  public void handle(HttpServletRequest req) {
    String user = org.owasp.encoder.Encode.forHtml(req.getParameter("user"));
    Logger.getLogger("app").warning("login user=" + user);
  }
}
