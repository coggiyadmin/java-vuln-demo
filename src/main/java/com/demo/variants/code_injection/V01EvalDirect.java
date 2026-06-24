package com.demo.variants.code_injection;

import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;
public class V01EvalDirect {
    public void eval(HttpServletRequest req) throws Exception {
        String code = req.getParameter("code");
        new ScriptEngineManager().getEngineByName("js").eval(code); // SINK CWE-94
    }
}
