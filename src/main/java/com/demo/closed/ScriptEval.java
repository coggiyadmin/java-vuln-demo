package com.demo.closed;
import javax.script.ScriptEngineManager;
// cognium-dev#619 — script evaluation is code injection, not a dropped command sink
public class ScriptEval {
  public void run(String script) throws Exception {
    new ScriptEngineManager().getEngineByName("js").eval(script); // SINK CWE-94
  }
}
