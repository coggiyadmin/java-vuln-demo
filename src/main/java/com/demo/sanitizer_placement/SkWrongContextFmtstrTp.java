package com.demo.sanitizer_placement;
import java.util.*;
import javax.servlet.http.*;
public class SkWrongContextFmtstrTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String fmt = req.getParameter("fmt").replace("<", "&lt;");
    new Formatter(resp.getWriter()).format(fmt, "guest");
  }
}
