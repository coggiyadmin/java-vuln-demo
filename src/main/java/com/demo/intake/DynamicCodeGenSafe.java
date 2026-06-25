package com.demo.intake;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/** Safe mirror — constant generated expression; no user-controlled codegen. */
public class DynamicCodeGenSafe {
    public Object run() throws Exception {
        ScriptEngine eng = new ScriptEngineManager().getEngineByName("javascript");
        String generated = "function f(){ return 1 + 1; } f();";
        return eng.eval(generated);
    }
}
