package com.demo.sanitizer_placement;
import javax.script.*;
import javax.servlet.http.*;
public class SkWrongContextCodeinjTp {
  public void handle(HttpServletRequest req) throws Exception {
    String q = req.getParameter("q").replace("'", "''");
    new ScriptEngineManager().getEngineByName("js").eval(q);
  }
}
