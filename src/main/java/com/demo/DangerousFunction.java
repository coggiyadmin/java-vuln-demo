package com.demo;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-242 Use of Inherently Dangerous Function. `ScriptEngine.eval` executes
 * arbitrary script in-process and is dangerous by design. Real vuln; NO finding = FN.
 */
public class DangerousFunction {

    public Object calc(HttpServletRequest request) throws Exception {
        String expr = request.getParameter("e");
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        return engine.eval(expr);                 // inherently dangerous function → CWE-242
    }
}
