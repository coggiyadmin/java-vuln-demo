package com.demo.sanitizer_placement;
import java.util.regex.*;
import javax.servlet.http.*;
public class SkWrongContextRedosTp {
  public void handle(HttpServletRequest req) throws Exception {
    String pattern = req.getParameter("p").replace("'", "''");
    Pattern.compile(pattern).matcher(req.getParameter("t")).matches();
  }
}
