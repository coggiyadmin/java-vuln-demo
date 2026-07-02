package com.demo.sanitizer_placement;
import java.util.regex.*;
import javax.servlet.http.*;
public class SkFakeRedosTp {
  public void handle(HttpServletRequest req) throws Exception {
    String pattern = req.getParameter("p").replace("SAFE", "");
    Pattern.compile(pattern).matcher(req.getParameter("t")).matches();
  }
}
