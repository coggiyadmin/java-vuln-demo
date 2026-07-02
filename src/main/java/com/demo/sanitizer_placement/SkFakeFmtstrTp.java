package com.demo.sanitizer_placement;
import java.util.*;
import javax.servlet.http.*;
public class SkFakeFmtstrTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String fmt = req.getParameter("fmt").replace("SAFE", "");
    new Formatter(resp.getWriter()).format(fmt, "guest");
  }
}
