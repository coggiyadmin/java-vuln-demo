package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import java.util.regex.Pattern;
/** SAN-P06 — chain validate then sink. */
public class SanP06SanitizeChain {
  public void handle(HttpServletRequest req) throws Exception {
    String t = req.getParameter("q").replace("<", "");
    if (!Pattern.compile("[a-zA-Z0-9 _-]+").matcher(t).matches()) return;
    Runtime.getRuntime().exec("grep " + t);
  }
}
