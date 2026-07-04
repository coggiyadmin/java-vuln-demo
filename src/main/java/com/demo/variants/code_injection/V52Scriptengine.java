package com.demo.variants.code_injection;

import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;
public class V52Scriptengine {
    public Object run(HttpServletRequest req) throws Exception {
        String script = req.getParameter("s"); // SOURCE
        return new ScriptEngineManager().getEngineByName("js").eval(script); // SINK CWE-94 ScriptEngine
    }
}
