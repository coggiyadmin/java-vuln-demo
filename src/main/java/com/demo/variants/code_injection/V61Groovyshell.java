package com.demo.variants.code_injection;

import groovy.lang.GroovyShell;
import javax.servlet.http.HttpServletRequest;
public class V61Groovyshell {
    public Object run(HttpServletRequest req) {
        String script = req.getParameter("s"); // SOURCE
        return new GroovyShell().evaluate(script); // SINK CWE-94 GroovyShell.evaluate
    }
}
