package com.demo.variants.code_injection;

import ognl.Ognl;
import javax.servlet.http.HttpServletRequest;
public class V80OgnlEval {
    public Object eval(HttpServletRequest req) throws Exception {
        String expr = req.getParameter("expr"); // SOURCE
        return Ognl.getValue(expr, new Object()); // SINK CWE-94 OGNL injection
    }
}
