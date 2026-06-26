package com.demo.taint.attack.app;
import javax.servlet.http.*;
import java.io.*;
public class As_xss_app {
  public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.getWriter().print("<p>" + req.getParameter("q") + "</p>");
  }
}
