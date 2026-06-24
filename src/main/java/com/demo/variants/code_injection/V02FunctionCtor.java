package com.demo.variants.code_injection;

import javax.servlet.http.HttpServletRequest;
public class V02FunctionCtor {
    public void fn(HttpServletRequest req) throws Exception {
        String expr = req.getParameter("expr");
        ((java.util.function.Supplier<Object>) Class.forName("java.util.function.Supplier")
            .getDeclaredConstructor().newInstance()).get();
        new javax.script.ScriptEngineManager().getEngineByName("js").eval(expr); // SINK CWE-94
    }
}
