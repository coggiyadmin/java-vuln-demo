package com.demo.taint.sources;
import javax.servlet.http.*;
import java.io.*;
public class SrcCookie {
  public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String v = null;
    if (req.getCookies() != null) for (var c : req.getCookies())
      if ("pref".equals(c.getName())) v = c.getValue(); // SOURCE SRC-04
    res.getWriter().print("<p>" + v + "</p>"); // SINK CWE-79
  }
}
