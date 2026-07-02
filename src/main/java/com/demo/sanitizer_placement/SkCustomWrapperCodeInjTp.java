package com.demo.sanitizer_placement;
import javax.script.*;
import javax.servlet.http.*;
public class SkCustomWrapperCodeinjTp {
  private static String companySanitize(String v) { return v.replace(";", ""); }
  public void handle(HttpServletRequest req) throws Exception {
    String code = companySanitize(req.getParameter("code"));
    new ScriptEngineManager().getEngineByName("js").eval(code);
  }
}
