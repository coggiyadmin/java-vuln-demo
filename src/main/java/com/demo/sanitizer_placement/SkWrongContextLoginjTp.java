package com.demo.sanitizer_placement;
import java.util.logging.*;
import javax.servlet.http.*;
public class SkWrongContextLoginjTp {
  public void handle(HttpServletRequest req) {
    String user = req.getParameter("user").replace("<", "&lt;");
    String pw = req.getParameter("password");
    Logger.getLogger("app").info("login user=" + user + " password=" + pw);
  }
}
