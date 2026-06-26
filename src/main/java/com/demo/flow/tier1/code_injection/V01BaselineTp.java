package com.demo.flow.tier1.code_injection;

import javax.script.*;
import javax.servlet.http.*;
public class V01BaselineTp {
    public Object run(HttpServletRequest req) throws Exception {
        String x = req.getParameter("x"); // SOURCE
        return new ScriptEngineManager().getEngineByName("js").eval(x); // SINK
    }
}
