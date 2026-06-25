package com.demo.intake;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;

/** TP — user input woven into generated script before eval (CWE-94 intake pattern). */
public class DynamicCodeGenTp {
    public Object run(HttpServletRequest req) throws Exception {
        String expr = req.getParameter("expr");
        ScriptEngine eng = new ScriptEngineManager().getEngineByName("javascript");
        String generated = "function f(){ return " + expr + "; } f();"; // user controls codegen
        return eng.eval(generated); // SINK CWE-94
    }
}
