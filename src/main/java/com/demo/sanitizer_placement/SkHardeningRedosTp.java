package com.demo.sanitizer_placement;
import java.util.regex.*;
import javax.servlet.http.*;
public class SkHardeningRedosTp {
  public void handle(HttpServletRequest req) throws Exception {
    String pattern = req.getParameter("p");
    if (pattern.length() > 64) throw new SecurityException("bad");
    Pattern.compile(pattern).matcher(req.getParameter("t")).matches();
  }
}
