package com.demo.sanitizer_placement;
import java.util.logging.*;
import javax.servlet.http.*;
public class SkHardeningLoginjTp {
  public void handle(HttpServletRequest req) {
    String user = req.getParameter("user").replace("\n", "");
    String pw = req.getParameter("password").replace("\n", "");
    Logger.getLogger("app").info("login user=" + user + " password=" + pw);
  }
}
