package com.demo.intake;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

/** TP — user input drives JNDI lookup (CWE-94 intake pattern). CVE-2022-22963 Log4Shell class. */
public class Log4jJndiTp {
    public Object lookup(HttpServletRequest req) throws Exception {
        String resource = req.getParameter("resource");
        Context ctx = new InitialContext();
        return ctx.lookup(resource); // SINK CWE-94 JNDI
    }
}
