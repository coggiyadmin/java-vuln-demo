package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFrameworkNativeCodeinjTp {
  public void handle(HttpServletRequest req) throws Exception {
    String expr = org.owasp.encoder.Encode.forHtml(req.getParameter('expr'));
    new javax.script.ScriptEngineManager().getEngineByName('js').eval(expr);
  }
}
