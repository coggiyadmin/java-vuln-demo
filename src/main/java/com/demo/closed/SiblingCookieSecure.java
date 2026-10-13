package com.demo.closed;
import javax.servlet.http.*;
// cognium-dev#595 — setSecure(true) on one cookie must not hide setSecure(false) on another
public class SiblingCookieSecure extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) {
    Cookie ok = new Cookie("session", "1");
    ok.setSecure(true);
    resp.addCookie(ok);
    Cookie bad = new Cookie("pref", req.getParameter("p"));
    bad.setSecure(false);
    resp.addCookie(bad); // SINK CWE-614
  }
}
