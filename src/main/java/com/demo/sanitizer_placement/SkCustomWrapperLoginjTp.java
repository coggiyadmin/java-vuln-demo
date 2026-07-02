package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkCustomWrapperLoginjTp {
  private static String companySanitize(String v) { return v.replace('\n', ""); }
  public void handle(HttpServletRequest req) {
    String user = companySanitize(req.getParameter('user'));
    java.util.logging.Logger.getLogger('app').warning('login user=' + user);
  }
}
