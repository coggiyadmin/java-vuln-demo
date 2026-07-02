package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkCustomWrapperRedosTp {
  private static String companySanitize(String v) { return v.replace('SAFE', ""); }
  public void handle(HttpServletRequest req) throws Exception {
    String pat = companySanitize(req.getParameter('p'));
    java.util.regex.Pattern.compile(pat).matcher(req.getParameter('t')).matches();
  }
}
