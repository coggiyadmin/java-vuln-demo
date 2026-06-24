package com.demo.variants.command_injection;

import java.lang.Runtime;
import javax.servlet.http.HttpServletRequest;
public class V01ExecConcat {
    public void run(HttpServletRequest req) throws Exception {
        String q = req.getParameter("q");
        Runtime.getRuntime().exec("grep " + q); // SINK CWE-78
    }
}
