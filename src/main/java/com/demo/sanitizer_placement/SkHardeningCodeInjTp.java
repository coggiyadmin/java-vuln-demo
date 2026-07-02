package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkHardeningCodeinjTp {
  public void handle(HttpServletRequest req) throws Exception {
    String expr = req.getParameter('expr').replace('import', '');
    new javax.script.ScriptEngineManager().getEngineByName('js').eval(expr);
  }
}
