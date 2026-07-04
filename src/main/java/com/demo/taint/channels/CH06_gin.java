package com.demo.taint.channels;
import javax.servlet.http.*;
public class CH06_gin {
  public void go(HttpServletRequest req, HttpServletResponse res) throws Exception {
    res.sendRedirect(req.getParameter("next")); // SINK CWE-601
  }
}
