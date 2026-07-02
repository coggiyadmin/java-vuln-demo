package com.demo.sanitizer_placement;
import javax.script.*;
import javax.servlet.http.*;
public class SkFakeCodeinjTp {
  public void handle(HttpServletRequest req) throws Exception {
    String q = req.getParameter("q").replace("SAFE", "");
    new ScriptEngineManager().getEngineByName("js").eval(q);
  }
}
